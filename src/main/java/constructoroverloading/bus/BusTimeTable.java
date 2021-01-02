package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {

    List<SimpleTime> timeTable = new ArrayList<>();

    public BusTimeTable (List<SimpleTime> timeTable){
        this.timeTable = timeTable;
    }

    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        for (int i = 0; i < lastHour-firstHour+1 ; i++) {
            timeTable.add(new SimpleTime(firstHour+i, everyMinute));
        }
    }

    public List<SimpleTime> getTimeTable(){
        return timeTable;
    }

    public SimpleTime nextBus(SimpleTime actual){
        if (timeTable.isEmpty()){
            throw new IllegalArgumentException("No more buses today!");
        }
        for (SimpleTime times : timeTable){
            if (actual.getHours() <= times.getHours()){
                if (actual.getMinutes() <= times.getMinutes())
                    return times;
            }
        } throw new IllegalStateException("No more buses today!");

    }
}
