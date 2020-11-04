package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List <String> capsuleColor = new ArrayList<>();

    public void addLast(String capsule) {
        capsuleColor.add(capsule);
    }
    public void addFirst(String capsule) {
        capsuleColor.add(0,capsule);
    }
    public void removeLast(String capsule) {
        capsuleColor.remove(capsule);
    }
    public void removeFirst(String capsule) {
        capsuleColor.remove(capsuleColor.size() -1 );
        
    }
}
