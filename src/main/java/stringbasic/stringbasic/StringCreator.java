package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap(){
        String hello = new String("hello");
        return hello;
    }
    public String createStringForPool(){
        String other = "hello".intern();
        return other;
    }


}
