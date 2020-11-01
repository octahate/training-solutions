package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message = message + 444;
        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");
        System.out.println(""+"");
        System.out.println("abcde".length());
        System.out.println("abcde".substring(0,1) + "," + "abcde".substring(2,3));
        System.out.println("abcde".substring(0,3));

    }
}
