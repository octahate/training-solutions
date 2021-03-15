package typeconversion.dataloss;

public class DataLoss {

    public void dataLoss(){
        long first = 0L;
        while (first == (long) toFloat(first)){
            first++;
        }
        System.out.println(first);
        System.out.println(first+1);
        System.out.println(first+2);
    }

    private float toFloat(long number){
        return (float) number;
    }

    public static void main(String[] args) {
        DataLoss dl = new DataLoss();
        dl.dataLoss();
    }
}
