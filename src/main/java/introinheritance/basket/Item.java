package introinheritance.basket;

public class Item {

    String barcode;
    double nettoPrice;
    int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public double getTaxAmount(){
        return ((double) vatPercent * nettoPrice) / 100;
    }


    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPercent=" + vatPercent +
                '}';
    }
}
