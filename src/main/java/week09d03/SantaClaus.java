package week09d03;

import java.util.List;

public class SantaClaus {
    List<Person> gifteds;

    public SantaClaus(List<Person> gifteds) {
        this.gifteds = gifteds;
    }

    public void getThroughChimney(){
        for (Person giveit : gifteds){
            giveit.setPresent();
        }
    }
}

