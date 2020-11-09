package literals;

import java.util.Locale;

public class LiteralsMain {
    public static void main(String[] args) {
        String one = "1";
        String two = "2";
        System.out.println(one + two );
        int onei = 1;
        int twoi = 2;
        System.out.println(String.valueOf(onei) + String.valueOf(twoi));
        System.out.println("1" + "2");

        double quotient = 3/4F;
        System.out.println(quotient);

        long big = 3_244_444_444L;

        String s = "árvíztűrőtükörfúrógép";

        String word = "title".toUpperCase();
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));



    }
}
