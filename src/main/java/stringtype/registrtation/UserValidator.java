package stringtype.registrtation;

public class UserValidator {

        public boolean isValidUsername(String username){
            return username.length() > 0;
        }
        public boolean isValidPassword (String password1, String password2){
            return password1.equals(password2)
                    && password1.length() >= 8;
        }
        public boolean isValidEmail (String email){
            int atWhere = email.indexOf("@");
            int dotWhere = email.indexOf('.');
            return (atWhere > 0 &&  dotWhere > atWhere && dotWhere < (email.length()-1));
                    }

        }


