package introcontrol;

public class IntroControl {

    public int substractTenIfGreaterThanTen (int number) {
      if (number <= 10) {
          return number;
      } else {
          return (number - 10);}
    }
    public String describeNumber (int number) {
        if (number == 0) {
            return "zero";
        } else {
            return "not zero";
        }

    }
    public String greetingToJoe(String name){
        if (name.equals("Joe")){
            return "Hello Joe";
        } else {
            return "";
        }
    }
    public int calculateBonus (int sale) {
        if (sale >= 1_000_000) {
            return (sale / 10);
        } else {
            return 0;
    }
        }
    public int calculateConsumption(int prev, int next) {
       if (prev <= next) {
           return next - prev;
       } else {
            return (next + 10000 ) - prev;}
       }

    public void printNumbers (int max) {
    for (int i = 0; i<=max; i++) {
        System.out.println(i);
    }}}


