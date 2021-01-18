package week12d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        int[] solution = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > 40 && grades[i] % 5 < 3) {
                solution[i] = (grades[i] + 5 - (grades[i] % 5));
            } else {
                solution[i] = grades[i];
            }
        }
        return solution;
    }
}
