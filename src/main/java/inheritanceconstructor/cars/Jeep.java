package inheritanceconstructor.cars;

public class Jeep extends Car{

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel){
        if (super.getFuel() + extraFuel < fuel){
            throw new IllegalArgumentException("Too much fuel!");
        }
        if ((extraCapacity - extraFuel) < fuel){
            throw new IllegalArgumentException("I have no idea what I am coding at this moment please just let me sleep")
        }

    }

}
