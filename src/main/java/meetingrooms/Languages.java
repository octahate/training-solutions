package meetingrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Languages {
    public static void main(String[] args) {
        List<String> List = Arrays.asList("Java","Python","JavaScript");
        for (int i= 0; i < List.size(); i++){
            if (List.get(i).length() > 5) {
                System.out.println(List.get(i));
            }
        }

    }
}
