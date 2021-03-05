package covid;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CovidDao {

    public DataSource initializeDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/vaccinetracker?useUnicode=true");
        ds.setUser("doctor");
        ds.setPassword("vaccine");
        return ds;
    }

    public DataSource initializeTestDataSource() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/vaccinetrackertest?useUnicode=true");
        ds.setUser("doctor");
        ds.setPassword("vaccine");
        return ds;
    }

    public void addPersonToDatabase(DataSource ds, String[] data) {
        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("INSERT INTO `citizens` (`citizen_name`, `zip`, `age`, `email`, `taj`, number_of_vaccination) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            smt.setString(1, data[0]);
            smt.setString(2, data[1]);
            smt.setInt(3, Integer.parseInt(data[2]));
            smt.setString(4, data[3]);
            smt.setString(5, data[4]);
            smt.setInt(6, 0);
            smt.executeUpdate();

        } catch (SQLException throwables) {
            throw new IllegalStateException("Can not insert into row");
        }
    }

    public void massDatabaseFill(DataSource ds, String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(";");
                addPersonToDatabase(ds, result);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public String returnCitiesWithZipcodeStatement(DataSource ds, int zipcode) {
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select city from cities where zip = ?");
        ) {
            stmt.setLong(1, zipcode);
            List<String> name = new ArrayList<>();
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    name.add(rs.getString("city"));
                }
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("No such city exists!");
                }
                return String.join(",", name.toArray(new String[0]));
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by query", sqle);
        }
    }

    public int returnAmountOfDoses(DataSource ds, String ssn) {
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select number_of_vaccination from citizens where taj = ?");
        ) {
            stmt.setString(1, ssn);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    return rs.getInt("number_of_vaccination");
                }
                throw new IllegalArgumentException("Nincsen ilyen beteg az adatbázisban!");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by insert", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by query", sqle);
        }
    }

    public void addDoseOfVaccine(DataSource ds, String ssn, String vaccineType, String administer) {
        int citizen_id = 0;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select citizen_id from citizens where taj = ?");
                PreparedStatement stmt2 =
                        conn.prepareStatement("insert into vaccinations(status,vaccination_date, vaccination_type, citizen_id) values (?,?,?,?)")) {
            stmt.setInt(1, Integer.parseInt(ssn));
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    citizen_id = rs.getInt("citizen_id");
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
            stmt2.setInt(4, citizen_id);
            stmt2.setString(1, "success");
            stmt2.setTimestamp(2, Timestamp.valueOf(administer));
            stmt2.setString(3, vaccineType);
            stmt2.executeUpdate();
            updateVaccineAmount(ds, ssn);
            updateVaccineTime(ds, ssn, administer);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }

    }

    private void updateVaccineAmount(DataSource ds, String snn) {
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE citizens SET citizens.number_of_vaccination = citizens.number_of_vaccination + 1 WHERE taj = ?;");
        ) {
            stmt.setString(1, snn);
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    private void updateVaccineTime(DataSource ds, String snn, String vaccinationTime) {
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("UPDATE citizens SET last_vaccination = ? WHERE taj = ?;");
        ) {
            stmt.setString(2, snn);
            stmt.setTimestamp(1, Timestamp.valueOf(vaccinationTime));
            stmt.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public String getFirstDoseInformation(DataSource ds, String ssn) {
        String vaccineType = null;
        String DateTime = null;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT vaccinations.vaccination_type, vaccinations.vaccination_date FROM citizens LEFT JOIN vaccinations ON citizens.citizen_id = vaccinations.citizen_id WHERE taj = ?");
        ) {
            stmt.setString(1, ssn);
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    DateTime = rs.getTimestamp("vaccination_date").toString();
                    vaccineType = rs.getString("vaccination_type");
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
            System.out.println(vaccineType + " , " + DateTime);
            return vaccineType;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void addInvalidVaccine(DataSource ds, String ssn, String error) {
        int citizen_id = 0;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select citizen_id from citizens where taj = ?");
                PreparedStatement stmt2 =
                        conn.prepareStatement("insert into vaccinations(status,note, citizen_id) values (?,?,?)")
        ) {
            stmt.setInt(1, Integer.parseInt(ssn));
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                if (rs.next()) {
                    citizen_id = rs.getInt("citizen_id");
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by query", sqle);
            }
            stmt2.setString(1, "failed");
            stmt2.setString(2, error);
            stmt2.setInt(3, citizen_id);
            stmt2.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void generateVaccinationList(DataSource ds, String zip) {
        Path file = Path.of("src/main/resources/" + zip + ".csv");
        LocalTime firstHour = LocalTime.of(8,0);
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT citizens.citizen_name , citizens.age, citizens.email, citizens.taj FROM citizens WHERE citizens.number_of_vaccination = 0 AND citizens.zip = ? ORDER BY citizens.age DESC, citizens.citizen_name ASC LIMIT 16");
        ) {
            stmt.setString(1, zip);
            try (
                    ResultSet rs = stmt.executeQuery();
                    BufferedWriter writer = Files.newBufferedWriter(file);
            ) {
                writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
                if (rs.next()) {
                    writer.write(firstHour.getHour() + ":" + firstHour.getMinute());
                    writer.write(";");
                    writer.write(rs.getString("citizen_name"));
                    writer.write(";");
                    writer.write(zip);
                    writer.write(";");
                    writer.write(rs.getString("age"));
                    writer.write(";");
                    writer.write(rs.getString("email"));
                    writer.write(";");
                    writer.write(rs.getString("taj"));
                    writer.write("\n");
                    firstHour = firstHour.plusMinutes(30);
                }
            } catch (SQLException | IOException sqle) {
                throw new IllegalArgumentException("Error by query or by writing file", sqle);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }

    public void generateReport(DataSource ds, String ssn) {
        Path file = Path.of(ssn + ".csv");
        LocalTime firstHour = LocalTime.of(8,0);
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT citizens.citizen_name , citizens.age, citizens.email, citizens.taj FROM citizens WHERE citizens.number_of_vaccination = 0 AND citizens.zip = ? ORDER BY citizens.age DESC, citizens.citizen_name ASC LIMIT 16");
        ) {
            stmt.setString(1, ssn);
            try (
                    ResultSet rs = stmt.executeQuery();
                    BufferedWriter writer = Files.newBufferedWriter(file);
            ) {
                writer.write("Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám\n");
                if (rs.next()) {
                    writer.write(firstHour.getHour() + ":" + firstHour.getMinute());
                    writer.write(rs.getString("citizen_name"));
                    writer.write(rs.getInt("age"));
                    writer.write(rs.getString("email"));
                    writer.write(rs.getString("taj"));
                    writer.write("\n");
                    firstHour = firstHour.plusMinutes(30);
                }
            } catch (SQLException | IOException sqle) {
                throw new IllegalArgumentException("Error by query orby writing file", sqle);
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot insert", se);
        }
    }
}


