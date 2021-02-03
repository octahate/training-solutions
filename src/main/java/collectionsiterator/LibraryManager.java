package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Book nextBook : libraryBooks) {
            if (nextBook.getRegNumber() == regNumber)
                return nextBook;
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int libraryBooksCount(){
        return libraryBooks.size();
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> b = libraryBooks.iterator();
        while (b.hasNext()){
            int regnum = b.next().getRegNumber();
            if (regNumber == regnum){
                b.remove();
                return regnum;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author){
        Iterator<Book> b = libraryBooks.iterator();
        Set<Book> booksByAuthor = new HashSet<>();
        while (b.hasNext()){
            Book currentBook = b.next();
            if (currentBook.getAuthor().equals(author)){
                booksByAuthor.add(currentBook);
            }
        }
        if (booksByAuthor.isEmpty()){
            throw new MissingBookException("No books found by " + author);
        }
        return booksByAuthor;
    }

}
