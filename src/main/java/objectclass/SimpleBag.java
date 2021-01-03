package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {
    private List<Object> items = new ArrayList<>();
    private int cursor = 0;

    public SimpleBag() {
        beforeFirst();
    }

    public void putItem(Object item){
        items.add(item);
    }

    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return items.size();
    }

    public void beforeFirst(){
        cursor = -1;
    }

    public boolean hasNext(){
        if (items.size() > cursor + 1){
            return true;
        }
        return false;
    }

    public Object next(){
        cursor++;
        return items.get(cursor);
    }

    public boolean contains(Object item){
        for (int i = 0; i < items.size(); i++) {
            if (item.equals(items.get(i)))
                return true;
        }
        return false;
    }

    public int getCursor(){
        return cursor;
    }

}
