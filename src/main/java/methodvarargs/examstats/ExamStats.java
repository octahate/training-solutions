package methodvarargs.examstats;

public class ExamStats {
    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
        if (results == null || results.length == 0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
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
        if (results.length == 0){
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
        int cutoff = (int) (limitInPercent * maxPoints * 0.01);
        for (int result : results) {
            if (result < cutoff){
                return true;}
            }
        return false;
        }
    }

