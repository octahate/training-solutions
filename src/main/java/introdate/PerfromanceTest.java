package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerfromanceTest {
    public static void main(String[] args) {
        Performance performance = new Performance(LocalDate.of(1995,12,20), "YOULI", LocalTime.of(12,00),LocalTime.of(14,00));
        System.out.println(performance.getInfo());
    }

}
