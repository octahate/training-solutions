package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class workdayCalculator {

    private Day nextDay (Day day) {
        if (day.ordinal() == (Day.values().length - 1)) { //ha az adott day sorszáma egyenlő a hosszával (ie. 7) akkor a hétfőt adja vissza a 0. elemet
            return Day.values()[0];
        } else {
            return Day.values()[day.ordinal() + 1]; //egyéb esetben a day+1 értékét
        }
    }


    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> types = new ArrayList<>(); // az output listát meg kell hívnunk
        Day day = firstDay; //a napot behelyezzük egy day nevű Day típusú változóba
        for (int i = 0; i < numberOfDays; i++) { //number of days hogy meddig iteráljuk
            types.add(day.getDayType()); // a types listához hozzáadjuk a nap DayTypeját
            day = nextDay(day); //a következő napra rátérünk
        }
        return types;
    }

}
