package week07d01;

public class MathAlgorithms {

    public static boolean isPrime (int x) {
        if (x > 0 ){
            throw new IllegalArgumentException("Pozitív legyen");
        }
        boolean isPrime = true;
        if (x == 1 && x == 2){
            return isPrime;
        }
        for (int i = 2; i < x-1; i++){
            if (x % i == 0){
                isPrime = false;
            }
        }
        return isPrime;
    }

}
