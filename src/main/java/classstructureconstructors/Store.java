package classstructureconstructors;

public class Store {
    private int stock;
    private String product;
    public int getStock() {
        return stock;
    }

    public String getProduct() {
        return product;
    }




   public Store (String product) {
       this.product = product;
       stock = 0;
   }
   public void store (int amount) {
       this.stock = stock + amount;
   }
    public void dispatch (int amount) {
        this.stock = stock - amount;
    }
}
