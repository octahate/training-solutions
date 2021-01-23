package ioreaderclasspath;

public class Country {

    private String country;
    private int borderCountries;

    public Country(String country, int borderCountries) {
        this.country = country;
        this.borderCountries = borderCountries;
    }

    public String getName() {
        return country;
    }

    public int getBorderCountries() {
        return borderCountries;
    }
}
