package week06d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {
    List<String> words = new ArrayList<>();

    public String retu (List<String> words){
        if (words == null){
            throw new NullPointerException("A lista üres");
        }
        String retu = "";
        for (int i=0; i < words.size(); i++){
            if (i % 2 == 0){
                retu = retu + words.get(i);
            }
        }
        if (retu.length() > 0 ){
            retu = "[" + retu + "]";
        }
        return retu;
    }
}
