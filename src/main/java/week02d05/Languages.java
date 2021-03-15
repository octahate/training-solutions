package week02d05;

import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<CharSequence> languages = List.of("Java","Python","JavaScript");
        for (CharSequence currentLang : languages){
            if (currentLang.length() > 5 ){
                System.out.println(currentLang);
            }
        }
    }
}
