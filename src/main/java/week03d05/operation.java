package week03d05;

public class operation {
    private int left;
    private int right;

    public operation(String enumeration) {
        int cross = enumeration.indexOf("+");
        String leftString = enumeration.substring(0,cross);
        String rightString = enumeration.substring(cross+1);
        this.left = Integer.parseInt(leftString);
        this.right = Integer.parseInt(rightString);

    }

    public int getResult(){
        return left + right;
    }
}
