package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray){
        this.bookArray = bookArray;
    }

    public Book[] sortingById(){
        Arrays.sort(bookArray);
        return bookArray;
    }

    public Book[] sortingByTitle(){
        Arrays.sort(bookArray, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return bookArray;
    }



}
