package SoftwarePrices;

public class DeveloperSoftware extends Software{


    protected DeveloperSoftware(String name, int price) {
        super(name, price);
    }

    @Override
    public void increasePrice() {
        this.price += price * 0.1;
    }
}
