package jdbc.architechture;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private DataSource ds;

    public EmployeesDao(DataSource ds) {
        this.ds = ds;
    }

    public long createEntry(String name) {
        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("insert into employees(emp_name) values (?)", Statement.RETURN_GENERATED_KEYS);
        ) {
            smt.setString(1, name);
            smt.executeUpdate();
            return getIdByStatement(smt);
        } catch (SQLException throwables) {
            throw new IllegalStateException("can not insert");
        }
    }

    public void createEmployeesList(List<String> names){
        try (Connection conn = ds.getConnection();) {
            conn.setAutoCommit(false);
            try (PreparedStatement stmt = conn.prepareStatement("insert into employees (emp_name) values (?)")){
                for (String name: names ){
                    if (name.startsWith("x")) {
                     throw new IllegalArgumentException("Invalid name!");
                    }
                    stmt.setString(1,name);
                    stmt.executeUpdate();
                }
                conn.commit();
            }
            catch (IllegalArgumentException iae){
                conn.rollback();
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot insert");
        }
    }

    private long getIdByStatement(PreparedStatement smt) {
        try (
                ResultSet rs = smt.getGeneratedKeys();
        ) {
            if (rs.next()) {
                return rs.getLong(1);
            }
            throw new IllegalStateException("Cannot get ID");
        }
        catch (SQLException sql){
            throw new IllegalStateException("Cannot find it.");
        }
    }

    public String findEmployeeNameById(long id) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("select emp_name from employees where id = ?");
        ) {
            ps.setLong(1, id);

            return selectNameByPreparedStatement(ps);
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    private String selectNameByPreparedStatement(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                return name;
            }
            throw new IllegalArgumentException("Not found");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<String> listEmployeeNames() {
        try (
                Connection conn = ds.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select emp_name from employees")
        ) {
            List<String> names = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("emp_name");
                names.add(name);
            }
            return names;
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot select");
        }
    }
}
