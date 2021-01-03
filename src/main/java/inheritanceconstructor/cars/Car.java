package inheritanceconstructor.cars;

public class Car {

    private double fuelRate;
    private double fuel;
    private double tankCapacity;

    public Car(double fuelRate, double fuel, double tankCapacity) {
        if (fuel > tankCapacity){
            throw new IllegalArgumentException("Tank capacity is less than fuel!");
        }
        this.fuelRate = fuelRate;
        this.fuel = fuel;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void modifyFuelAmount(double fuel) {
        if (this.fuel + fuel > tankCapacity){
            throw new IllegalArgumentException("Too much fuel!");
        }
        this.fuel = this.fuel + fuel;
    }

    public void drive (int km){
        if (fuel - ((fuelRate/100)*km) < 0){
            throw new IllegalArgumentException("Not enough fuel available!");
        }
    modifyFuelAmount(-((fuelRate/100)*km));
    }

    public double calculateRefillAmount(){
        return tankCapacity - fuel;
    }
}
