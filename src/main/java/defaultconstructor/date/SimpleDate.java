package defaultconstructor.date;

public class SimpleDate {
    private int year;
    private int month;
    private int day;

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0)) {
            return true;
        } else return (year % 400 == 0);
    }

    public int calculateMonthLength(int year, int month) {
        boolean leapYear = isLeapYear(year);
        int monthLength = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthLength = 31;
                break;
            case 2:
                if (leapYear == true) {
                    monthLength = 29;
                } else {
                    monthLength = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthLength = 30;
                break;
        }
        return monthLength;
    }

    public boolean isCorrect(int year, int month, int day) {
        if (year < 1990) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }

        if (calculateMonthLength(year, month) < day) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        return true;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(int year, int month, int day) {
        if (isCorrect(year, month, day) == true) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }
}


