package defaultconstructor.date;

public class SimpleDateFormatter {

    public SimpleDateFormatter() {

    }

    public String formatDateString(SimpleDate simpleDate) {
        return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
    }

    public String formatDateStringByCountryCode(CountryCode country, SimpleDate simpleDate) {
        if (country.equals(CountryCode.HU)) {
            return formatDateString(simpleDate);
        } else if (country.equals(CountryCode.EN)) {
            return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
        } else return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
    }
}
