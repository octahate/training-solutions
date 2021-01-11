package exceptionclass.course;

import static java.lang.Integer.parseInt;

public class SimpleTime {

    private int hour;
    private int minutes;

    public SimpleTime(int hour, int minutes) {
        if (hour < 0 || hour > 23){
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if(minutes < 0 || minutes > 59){
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minutes = minutes;
    }

    public SimpleTime(String time) {
        if (time == null){
            throw new InvalidTimeException("Time is null");
        }

        int hourTest;
        int minutesTest;
        try {
            hourTest = parseInt(time.substring(0, time.indexOf(":")));
            minutesTest = parseInt(time.substring(time.indexOf(':') + 1, time.indexOf(':') + 3));
        } catch (StringIndexOutOfBoundsException | NumberFormatException ex) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        if (hourTest < 0 || hourTest > 23){
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minutesTest < 0 || minutesTest > 59){
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.minutes = minutesTest;
        this.hour = hourTest;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minutes);
    }
}
