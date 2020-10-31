package classstructureconstructors;

public class Store {

    private int stock;
    private String product;

    public int getStock() {
        return stock;
    }

    public Store (String product) {
        this.product = product;
        stock = 0;
    }

    public String getProduct() {
        return product;
    }

      public void store (int amount) {
       this.stock = stock + amount;
   }
    public void dispatch (int amount) {
        this.stock = stock - amount;
    }
}
