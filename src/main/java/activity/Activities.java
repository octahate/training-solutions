package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activities {

    private List<Activity> listedActivities;

    public Activities(List<Activity> activities) {
        listedActivities = activities;
    }

    public void addActivity(Activity newOne) {
        listedActivities.add(newOne);
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity currentOne : listedActivities) {
            if (currentOne.isItTracked()) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity currentOne : listedActivities) {
            if (currentOne.isItTracked() == false) {
                counter++;
            }
        }
        return counter;
    }

    public List<Report> distancesByTypes() {
        double[] distances = new double[ActivityType.values().length];
        for (Activity currentActivity : listedActivities) {
            if (currentActivity.isItTracked()) {
                distances[currentActivity.getType().ordinal()] += currentActivity.getDistance();
            }
        }
        ActivityType[] types = ActivityType.values();
        List<Report> result = new ArrayList<>();
        for (int i = 0; i < types.length; i++) {
            result.add(new Report(types[i], distances[i]));
        }
        return result;
    }
}
