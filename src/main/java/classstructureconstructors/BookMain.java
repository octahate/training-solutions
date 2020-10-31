package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Orwell", "1984");
        System.out.println("Szerző: " + book.getAuthor());
        System.out.println("Cím: " + book.getTitle());
        book.setRegNumber("991");
        System.out.println("Nyilvántartási szám: " + book.getRegNumber());
    }

}
