package jdbc.simplequery;

import java.sql.Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public void selectNameByPreparedStatement(PreparedStatement prS){
        try (ResultSet rs = prS.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot read it!");
        }
    }

    public void selectNameById(DataSource ds, long id){
        try (Connection con = ds.getConnection();
             PreparedStatement prS = con.prepareStatement("select emp_name from employees where id = ?")
        ) {
            prS.setLong(1, id);
            selectNameByPreparedStatement(prS);
        } catch (SQLException throwables) {
            throw new IllegalStateException("Cannot read it!");
        }
    }
    public static void main(String[] args) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        ds.setUser("employees");
        ds.setPassword("sucoja");
        new FindByIdMain().selectNameById(ds, 2);
    }

}
