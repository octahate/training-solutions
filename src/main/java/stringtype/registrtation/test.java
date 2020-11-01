package stringtype.registrtation;

public class test {
    public static void main(String[] args) {
        String message = "Hello Java";
        int index = message.indexOf("J");
        System.out.println(index);
        String word = message.substring(index);

        System.out.println(word.length());
    }
}
