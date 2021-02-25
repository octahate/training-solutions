package jdbc.architechture;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class EmployeesMain {
    public static void main(String[] args) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        ds.setUser("employees");
        ds.setPassword("sucoja");

        new EmployeesDao(ds).createEntry("Jane Doe");
        System.out.println(new EmployeesDao(ds).findEmployeeNameById(1));
        System.out.println(new EmployeesDao(ds).listEmployeeNames());
    }

}
