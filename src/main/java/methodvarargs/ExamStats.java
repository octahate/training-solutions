package methodvarargs;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
        int cutoff = (int) (limitInPercent * maxPoints * 0.01);
        int achieve = 0;
        for (int result : results) {
            if (result > cutoff){
                achieve++;
            }
        }
        return achieve;
    }

    public boolean hasAnyFailed (int limitInPercent, int... results){
        int cutoff = (int) (limitInPercent * maxPoints * 0.01);
        for (int result : results) {
            if (result < cutoff){
                return true;}
            }
        return false;
        }
    }

