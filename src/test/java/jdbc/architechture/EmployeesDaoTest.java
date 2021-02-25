package jdbc.architechture;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeesDaoTest {

    private EmployeesDao employeesDao;

    @Before
    public void init() {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/employees?useUnicode=true");
        ds.setUser("employees");
        ds.setPassword("sucoja");

        Flyway flyway = Flyway.configure().dataSource(ds).load();

        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(ds);


    }

    @Test
    public void testInsert() {
        employeesDao.createEntry("John Doe");
        assertEquals(Arrays.asList("John Doe"), employeesDao.listEmployeeNames());
    }

    @Test
    public void testById() {
        long id = employeesDao.createEntry("Jack Doe");
        System.out.println(id);
        id = employeesDao.createEntry("Jane Doe");
        System.out.println(id);
        String name = employeesDao.findEmployeeNameById(id);
        assertEquals("Jane Doe", name);
    }

    @Test
    public void testCreateEmployees(){
        employeesDao.createEmployeesList(Arrays.asList("Jack Doe", "Jane Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("Jack Doe", "Jane Doe"), names);
    }

    @Test
    public void testCreateEmployeesRollback(){
        employeesDao.createEmployeesList(Arrays.asList("Jack Doe", "xJane Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Collections.emptyList(), names);
    }

}
