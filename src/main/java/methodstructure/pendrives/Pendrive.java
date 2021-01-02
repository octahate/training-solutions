package methodstructure.pendrives;

public class Pendrive {
    String name;
    int capacity;
    int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrives{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent) {
       double newPrice = percent * 0.01 * price;
       price = (int) ((int) price + newPrice);
    }

    public int comparePricePerCapacity(Pendrive otherone) {
        double fractionOfThisOne = (double) price / capacity;
        double fractionOfOtherOne =(double) otherone.getPrice() / otherone.getCapacity();
        if (fractionOfOtherOne > fractionOfThisOne) {
            return -1;
        } else if (fractionOfOtherOne < fractionOfThisOne) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean cheaperThan(Pendrive otherOne) {
        return (this.price < otherOne.price);
    }

}
