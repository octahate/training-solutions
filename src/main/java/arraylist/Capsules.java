package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Capsules {
    private List <String> capsuleColor = new ArrayList<>();

    public void addLast(String capsule) {
        capsuleColor.add(capsule);
    }
    public void addFirst(String capsule) {
        capsuleColor.add(0,capsule);
    }
    public void removeLast() {
        capsuleColor.remove(0);
    }

    public void removeFirst() {
        capsuleColor.remove(capsuleColor.size() - 1);
       }
    public List <String> getColors(){
        return capsuleColor;
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("zöld");
        capsules.addFirst("sárga");
        capsules.addFirst("piros");
        capsules.addLast("kék");
        capsules.removeFirst();
        capsules.removeLast();
        System.out.println(capsules.getColors());

    }
}
