package activitytracker;


import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityDaoTest {

    ActivityDao activityDao = new ActivityDao();

    @Before
    public void init() {
        Flyway flyway = Flyway.configure().dataSource(activityDao.initializeDataSource()).load();
        flyway.clean();
        flyway.migrate();
    }


    @Test
    public void testSaveActivityReadById() {
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(), "Test", Type.BIKING));
        assertEquals(new Activity(LocalDateTime.now(), "Test", Type.BIKING).getDesc(),activityDao.findActivityById(activityDao.initializeDataSource(),1).getDesc());
    }

    @Test
    public void testMakeList(){
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(), "test1", Type.BIKING));
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(), "test2", Type.HIKING));
        assertEquals(activityDao.listActivites(activityDao.initializeDataSource()).get(0).getDesc(), "test1");
        assertEquals(activityDao.listActivites(activityDao.initializeDataSource()).get(1).getType(),Type.HIKING);
    }

}
