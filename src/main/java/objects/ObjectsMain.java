package objects;

public class ObjectsMain {
    public static void main(String[] args) {
        class Book {
        }

        Book book = new Book();
        System.out.println(book);
        Book emptyBook = null ;
        System.out.println(emptyBook);
        System.out.println(emptyBook == null);
        System.out.println(book);
        Book anotherBook = new Book();
        System.out.println(book == anotherBook);
        anotherBook = book;
        System.out.println(book == anotherBook);
        System.out.println(anotherBook instanceof Book);
        System.out.println(book instanceof Book);

    }
    }

