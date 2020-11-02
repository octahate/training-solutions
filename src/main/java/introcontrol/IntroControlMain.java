package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introcontrol = new IntroControl();
        System.out.println(introcontrol.substractTenIfGreaterThanTen(15));
        System.out.println(introcontrol.substractTenIfGreaterThanTen(10));
        System.out.println(introcontrol.substractTenIfGreaterThanTen(32));
        System.out.println(introcontrol.describeNumber(0));
        System.out.println(introcontrol.describeNumber(1));
        System.out.println(introcontrol.calculateBonus(10000000));
        System.out.println(introcontrol.calculateBonus(400));


    }
}
