package exam02;

public class ArraySelector {

    public String selectEvens(int[] ints){
        if (ints.length == 0){
            return "";
        }
        StringBuilder finalString = new StringBuilder().append("[");
        for (int i = 0; i < ints.length; i=i+2) {
            finalString.append(ints[i]).append(", ");
        }
        finalString.deleteCharAt(finalString.length()-2).deleteCharAt(finalString.length()-1).append("]");
        return finalString.toString();
    }
}
