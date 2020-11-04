package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {
    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return numberOfDays.toString();
    }
    public List<String> daysOfWeek() {
        return Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap");
    }
    public boolean sameTempValues(double[] day, double[] anotherDay){
        return Arrays.equals(day,anotherDay);
    }
    public boolean wonLottery (int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        int[] a = {1,2,3,4};
        int[] b = {4,3,2,1};
        System.out.println(arraysMain.wonLottery (a,b));

        int[][] arrayInArray ={{1,2,3},{2,3,4},{1,2,3,4,5}};
        for(int i=0;i<arrayInArray.length;i++){
            for(int j=0;j<arrayInArray[i].length;j++){
                System.out.print(arrayInArray[i][j]);
            }
            System.out.println();
        }
    }



}
