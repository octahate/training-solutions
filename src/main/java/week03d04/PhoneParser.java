package week03d04;

public class PhoneParser {

    public Phone parse(String number){
        if (!number.contains("-") && number.length()!=11){
            throw new IllegalArgumentException("Number format is not good!");
        }
        return new Phone(number.split("-")[0],number.split("-")[1]);
    }
}
