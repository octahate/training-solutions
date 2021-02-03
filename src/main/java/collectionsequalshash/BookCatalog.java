package collectionsequalshash;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Set<Book> addBooksToSet(Book[] books) {
        return new HashSet<>(Arrays.asList(books));
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book actualBook : books) {
            if (actualBook.equals(book)) {
                return actualBook;
            }
        }
        if (!books.contains(book)) {
            return null;
        }
        return null;
    }

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book actualBook : books) {
            if (actualBook.getTitle().equals(title) && actualBook.getAuthor().equals(author)) {
                return actualBook;
            }
        }
        return null;
    }

}
