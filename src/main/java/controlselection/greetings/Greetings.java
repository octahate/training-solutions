package controlselection.greetings;

public class Greetings {

    public String greet(int hour, int minute) {
        String greeting = null;
        if ((hour >= 0 && hour < 5) || ( hour == 5 && minute == 0 )) {
                greeting = "jó éjt";
        } else if ((hour >= 5 && hour < 9) || ( hour == 9 && minute == 0 )) {
            greeting = "jó reggelt";}
        else if ((hour >= 9 && hour < 18) || ( hour == 18 && minute <= 30 )) {
            greeting = "jó napot";}
        else if ((hour >= 18 && hour < 20) || ( hour == 20 && minute == 0 )){
            greeting = "jó estét";}
        else return "jó éjt";

        return greeting;
    }
}

