package arraysofarrays;

public class ArrayOfArraysMain {
    public int[][] multiplicationTable(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiplicationTable;
    }
}
