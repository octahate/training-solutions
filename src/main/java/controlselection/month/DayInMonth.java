package controlselection.month;

public class DayInMonth {
    public int numberOfDays (int year, String month) {
        month = month.toLowerCase();
        int days = 0;
        switch (month) {
            case "április":
            case "június":
            case "szeptember":
            case "november":
                days = 30;
                break;
            case "január":
            case "március":
            case "május":
            case "július":
            case "augusztus":
            case "október":
            case "december":
                days = 31;
                break;
            case "február":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    days = 29;
                    break;
                } else {
                    days  = 28;
                    break;
                }
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return days; }
}



