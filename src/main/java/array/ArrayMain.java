package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] week = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] powersOfTwo = new int[5];
        powersOfTwo [0] = 1;

        int temp = 1;

        for (int i = 0; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = temp;
            temp *= 2;
        }
        for (int power : powersOfTwo) {
            System.out.println(power);
        }

        for (int i = 0; i < powersOfTwo.length; i++) {
            System.out.print(powersOfTwo[i] + " ");
        }
    }
}






