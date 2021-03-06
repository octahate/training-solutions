package timesheet;


import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportLineTest {

    RiportLine reportLine = new RiportLine(new Project("Java"), 10);

    @Test
    public void createReportLine() {
        assertEquals("Java", reportLine.getProject().getName());
        assertEquals(10L, reportLine.getTime());
    }

    @Test
    public void setTimeTest() {
        reportLine.addTime(2);
        assertEquals(12L, reportLine.getTime());
    }
}