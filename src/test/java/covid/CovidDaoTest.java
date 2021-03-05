package covid;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CovidDaoTest {

   CovidDao covidDao = new CovidDao();

    // `citizen_name`, `zip`, `age`, `email`, `taj`, number_of_vaccination
    private String[] first = new String[]{"Kovács Péter", "2022", "70", "test@test.com", "123461690"};

    @Before
    public void init() {
        Flyway flyway = Flyway.configure().dataSource(covidDao.initializeTestDataSource()).load();
        flyway.clean();
        flyway.migrate();

    }

    @Test
    public void testCreate(){
        covidDao.addPersonToDatabase(covidDao.initializeTestDataSource(),first);
        assertEquals(0,covidDao.returnAmountOfDoses(covidDao.initializeDataSource(),"123461690"));
    }

    @Test
    public void createUserAndAddADose(){
        covidDao.addPersonToDatabase(covidDao.initializeTestDataSource(),first);
        covidDao.addDoseOfVaccine(covidDao.initializeTestDataSource(), "123461690","Pfizer","2020-10-12 10:00:00");
        assertEquals("Pfizer",covidDao.getFirstDoseInformation(covidDao.initializeTestDataSource(),"123461690"));
    }

    @Test
    public void testBulkImport(){
        covidDao.massDatabaseFill(covidDao.initializeTestDataSource(),"src/main/resources/mockdatabase.csv");
        covidDao.addDoseOfVaccine(covidDao.initializeTestDataSource(), "123458809", "Moderna", "2020-12-10 12:00:00");
        assertEquals("Moderna", covidDao.getFirstDoseInformation(covidDao.initializeTestDataSource(),"123458809"));
    }

    @Test
    public void testInvalidVaccine(){
        covidDao.addPersonToDatabase(covidDao.initializeTestDataSource(),first);
        covidDao.addInvalidVaccine(covidDao.initializeTestDataSource(),"123461690","Anafilaxiás reakció a kórelőzményben");
        assertEquals(0,covidDao.returnAmountOfDoses(covidDao.initializeTestDataSource(),"123461690"));
    }

}
