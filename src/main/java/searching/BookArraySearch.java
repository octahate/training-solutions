package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
        if (author.isEmpty() || title.isEmpty() || author.isBlank() || title.isBlank()){
            throw new IllegalArgumentException("Author or title must not be empty!");
        }

        Arrays.sort(bookArray);
        int index = Arrays.binarySearch(bookArray,new Book(author,title));
        if (index < 0){
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return bookArray[index];
    }




}
