package genericsusage.genericsusage.withgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {




    public Book getFirstBook(List<Book> books){
        if (books.size() == 0){
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        if (books == null){
            throw new NullPointerException();
        }

        return books.get(0);
    }
}
