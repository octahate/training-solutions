package introexeption.patient;

public class SsnValidator {

    public boolean isValidSsn (String ssn){
        boolean isIsGood = true;
        if (ssn.length() != 9 ){
            isIsGood= false;
            return isIsGood;
        }
        for (int i=0; i<ssn.length(); i++){
            if(Character.isDigit(ssn.charAt(i)) == false){
                isIsGood = false;
                return isIsGood;
            }
        }
        int sum1 = 0;
        int sum2 = 0;

        for (int i=0; i <= ssn.length()-1; i = i+2){
            sum1 = sum1 + (ssn.charAt(i)*3);
        }
        for (int i=1; i <= ssn.length()-1; i = i+2){
            sum2 = sum2 + (ssn.charAt(i)*7);
        }

        if (((sum1+sum2)%10) == ssn.charAt(8) ){
            isIsGood= true;
            return isIsGood;

            //something is not okay but idk what prolly mathematical error
        } else isIsGood = false;
        return isIsGood;

    }
}
