package covid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public  final int SSN_LENGTH = 9;

    public String isNameValid(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        } else return name;
    }

    public String isZipValid(String zip) {
        if (zip.isEmpty() || zip.isBlank()) {
            throw new IllegalArgumentException("Az irányítószám nem lehet üres!");
        } else return zip;
    }

    public String isEmailValid(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Az e-mail cím nem megfelelő!");
        } else return emailStr;
    }

    public String isAgeValid(String age){
        if (age.isEmpty() || age.isBlank() || Integer.parseInt(age) < 10 || Integer.parseInt(age) > 150) {
            throw new IllegalArgumentException("Az életkor nem megfelelő!");
        } else return age;
    }

    public String isSNNValid(String ssn) {
        isSSNValidLength(ssn);
        int even = 0;
        int odd = 0;
        int validator = 0;
        try {
            for (int i = 0; i < ssn.length()-1; i+=2) {
                odd+=Integer.parseInt(ssn.substring(i,i+1));
            }
            for (int j = 1; j <ssn.length() ; j+=2) {
                even+=Integer.parseInt(ssn.substring(j,j+1));
            }
            validator = Integer.parseInt(ssn.substring(8));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("A TAJ szám formátuma nem megfelelő!");
        }
        if ((((odd * 3) + (even * 7)) % 10) != validator ){
            throw new IllegalArgumentException("A TAJ szám nem megfelelő!");
        }
        else return ssn;
    }

    private  boolean isSSNValidLength(String ssn){
        if (ssn.length() != SSN_LENGTH){
            throw new IllegalArgumentException("A TAJ szám hossza nem megfelelő!");
        }
        else return true;
    }
}
