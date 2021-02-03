package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {

    private List<Book> libraryBook;

    public OrderedLibrary(List<Book> libraryBook) {
        this.libraryBook = libraryBook;
    }

    public List<Book> orderedByTitle() {
        List<Book> solution = new ArrayList<>(List.copyOf(libraryBook));
        Collections.sort(solution);
        return solution;
    }

    public List<Book> orderedByAuthor() {
        List<Book> solution = new ArrayList<>(List.copyOf(libraryBook));
        solution.sort(new AuthorComparator());
        return solution;
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        List<String> solution = new ArrayList<>();
        Iterator<Book> books = libraryBook.iterator();
        while (books.hasNext()) {
            solution.add(books.next().getTitle());
        }
        Collections.sort(solution, Collator.getInstance(locale));
        return solution;
    }


}
