package exam03retake01;


public class CdvCheck {

    public boolean check(String number){
        if (number.length() != 10) {
            throw new IllegalArgumentException("A szám nem megfelelő hosszúságú!");
        }
        int sum = 0;
        int modulus = 0;
        for (int i = 0; i < 9; i++) {
            sum += parseIntValue(number.substring(i, i + 1)) * (i + 1);
        }
        modulus = parseIntValue(number.substring(9));
        return (sum % 11 == modulus);
    }

    private int parseIntValue(String currentValue){
        try {
            return Integer.parseInt(currentValue);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("A adószám formátuma nem megfelelő!", nfe);
        }
    }
}
