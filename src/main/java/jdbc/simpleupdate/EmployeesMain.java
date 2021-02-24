package jdbc.simpleupdate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesMain {

    public static void main(String[] args) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        ds.setUser("employees");
        ds.setPassword("sucoja");

        try (
                Connection cnn = ds.getConnection();
                PreparedStatement smt = cnn.prepareStatement("insert into employees(emp_name) values (?)");
                )
        {
            smt.setString(1, "Jane Doe");
            smt.executeUpdate();
        } catch (SQLException throwables) {
            throw new IllegalStateException("can not insert");
        }
    }
}