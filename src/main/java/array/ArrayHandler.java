package array;

public class ArrayHandler {
        public boolean contains(int[] source,int itemToFind) {
            for (int i=0; i < source.length; i++) {
                int item = source [i];
                if (item == itemToFind) {
                    return true;}
            }
            return false;
        }

    }

