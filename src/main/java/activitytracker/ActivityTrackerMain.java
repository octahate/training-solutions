package activitytracker;

import java.time.LocalDateTime;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDao();
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(),"test", Type.BASKETBALL));
        activityDao.saveActivity(activityDao.initializeDataSource(), new Activity(LocalDateTime.now(),"test2", Type.BIKING));
        System.out.println(Activity.getCounter());

    }
}
