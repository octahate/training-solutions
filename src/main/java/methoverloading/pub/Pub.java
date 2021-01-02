package methoverloading.pub;

import methoverloading.Time;

public class Pub {
    String name;
    Time time;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        Time time = new Time(hours, minutes);
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

    public Time getOpenFrom(){
        return time;
    }

    @Override
    public String toString() {
        return name + ";" + time.getHours() + ":" + time.getMinutes() ;
    }
}

