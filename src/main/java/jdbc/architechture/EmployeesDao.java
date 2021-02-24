package jdbc.architechture;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    public void createEntry(DataSource ds){
        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("insert into employees(emp_name) values (?)");
        ) {
            smt.setString(1, "Jane Doe");
            smt.executeUpdate();
        } catch (SQLException throwables) {
            throw new IllegalStateException("can not insert");
        }
    }

    public String findEmployeeNameById(DataSource ds, long id){
        try (
                Connection conn = ds.getConnection();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select emp_name from employees");
        ) {
            List<String> names = new ArrayList<>();
            while (resultSet.next()){
                String name = resultSet.getString("emp_name");
                names.add(name);
            }
            return names.toString();
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot select");
        }
    }
}
