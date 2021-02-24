package jdbc.simplequery;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectEmployeesMain {

    public static void main(String[] args) {

        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        ds.setUser("employees");
        ds.setPassword("sucoja");

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
            System.out.println(names);
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot select");
        }
    }
}
