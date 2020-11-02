package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] week = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};
        System.out.println(week[1]);
        System.out.println(week.length);

        int[] powers = new int[5];

        for (int i = 0; i < powers.length; i++) {
            powers[i] = 2 ^ i;
        }

        // ez hülyeséget ír ki

        for (int i = 0; i < powers.length; i++) {
            System.out.print(powers[i] + " ");
        }
        boolean[] yesno = new boolean[6];

        //ez se megy

    }
}






