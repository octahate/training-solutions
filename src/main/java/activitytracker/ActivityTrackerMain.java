package activitytracker;

import org.flywaydb.core.Flyway;

import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDao();
        Flyway flyway = Flyway.configure().dataSource(activityDao.initializeDataSource()).load();
        flyway.clean();
        flyway.migrate();
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(),"test", Type.BASKETBALL));
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(),"test2", Type.BIKING));
        System.out.println(activityDao.listActivites(activityDao.initializeDataSource()).toString());
        System.out.println(activityDao.findActivityById(activityDao.initializeDataSource(),1));

    }
}
