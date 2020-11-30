package week06d01;

import java.util.ArrayList;
import java.util.List;

public class ListSelector {
    private List<String> words = new ArrayList<>();

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String retu (List<String> words){
        if (words == null){
            throw new IllegalArgumentException("A lista üres");
        }
        String retu = "";
        for (int i=0; i < words.size(); i+=2){
                retu = retu + words.get(i)+ ",";
            }
        if (retu.length() > 0 ){
            retu = "[" + retu + "]";
        }
        return retu;
    }
}
