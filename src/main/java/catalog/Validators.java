package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String string){
        if (string == null || string.isBlank()){
            return true;
        } return false;
    }

    public static boolean isEmpty(List list){
        if (list == null || list.size() == 0){
            return true;
        } return false;
    }

}
