package SoftwarePrices;

public class OfficeSoftware extends Software{

    protected OfficeSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price += price * 0.05;
    }
}
