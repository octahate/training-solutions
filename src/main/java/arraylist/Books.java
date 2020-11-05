package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> books = new ArrayList<>();

    public void add(String book) {
        books.add(book);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        for (String title : books) {
            if (prefix.equals(title.substring(0, 5))) {
                results.add(title);
            }
        }
        return results;
    }

    public List<String> getTitles(){
        return books;
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.add("A Kis Herceg");
        books.add("Tenkes Kapitánya");
        books.add("Kincskereső Kisködmön");
        books.add("Harry Potter és a Tűz Serlege");
        books.add("Harry Potter és a Bölcsek Köve");
        System.out.println(books.getTitles());
        System.out.println(books.getTitles().size());
        System.out.println(books.findAllByPrefix("Harry"));

    }
}
