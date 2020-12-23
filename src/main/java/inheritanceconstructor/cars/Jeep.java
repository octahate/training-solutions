package inheritanceconstructor.cars;

public class Jeep extends Car {

    private double extraCapacity;
    private double extraFuel;

    public Jeep(double fuelRate, double fuel, double tankCapacity, double extraCapacity, double extraFuel) {
        super(fuelRate, fuel, tankCapacity);
        this.extraCapacity = extraCapacity;
        this.extraFuel = extraFuel;
    }

    public void modifyFuelAmount(double fuel) {
        if (fuel + extraFuel + super.getFuel() > super.getTankCapacity() + extraCapacity) {
            throw new IllegalArgumentException("Auxiliary capacity is less than extra fuel!");
        }
        if (fuel < 0) {
            if (extraFuel + fuel >= 0) {
                extraFuel = (extraFuel + fuel);
            } else {
                extraFuel = 0;
                super.modifyFuelAmount(extraFuel + fuel);
            }
        }
        if (fuel > 0) {
            if (fuel > super.getTankCapacity() - super.getFuel()) {
                extraFuel = (fuel - (super.getTankCapacity() - super.getFuel())); //megnézem mennyi marad
                super.modifyFuelAmount(super.getTankCapacity()); //feltöltöm a max értékére
            } else {
                extraFuel = extraFuel + fuel;
            }
        }
    }

    public void drive(int km){
        if (super.getFuel()+ extraFuel - (super.getFuelRate()* km) < 0){
            throw new IllegalArgumentException("Not enough fuel available!");
        }
        modifyFuelAmount(-(super.getFuelRate() * km));
    }

    public double calculateRefillAmount(){
        return (super.getTankCapacity() - super.getFuel()) + (extraCapacity-extraFuel);
    }
}
