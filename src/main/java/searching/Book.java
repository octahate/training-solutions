package searching;

import java.util.Objects;

public class Book implements Comparable<Book> {

    private int id;
    private String title;
    private String author;

    public Book(int id,  String author,String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String author, String title) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }

    @Override
    public int compareTo(Book o) {
        if (author.compareTo(o.author) != 0) {
            return author.compareTo(o.author);
        } else {
            return title.compareTo(o.title);
        }
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
