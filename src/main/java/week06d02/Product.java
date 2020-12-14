package week06d02;

public class Product {

    private String name;
    private Categories category;
    private int price;

    public String getName() {
        return name;
    }

    public Categories getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public Product(String name, Categories category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
