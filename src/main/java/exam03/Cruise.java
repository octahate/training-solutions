package exam03;

import collectionsautoboxing.IntegerOperations;
import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() <= passengers.size()) {
            throw new IllegalArgumentException("Boat is full! Cannot book passenger" + passenger.getName());
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger inputPassenger) {
        return (inputPassenger.getCruiseClass().multiplier) * (basicPrice);
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger currentPassenger : passengers) {
            if (currentPassenger.getName().equals(name)) {
                return currentPassenger;
            }
        }
        throw new IllegalArgumentException("Cannot find such passenger!");
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> nameList = new ArrayList<>();
        for (Passenger currentPassenger : passengers) {
            nameList.add(currentPassenger.getName());
        }
        Collections.sort(nameList);
        return nameList;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger currentPassenger : passengers) {
            sum += getPriceForPassenger(currentPassenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> map = new TreeMap<>();
        for (Passenger currentPassenger : passengers) {
            CruiseClass key = currentPassenger.getCruiseClass();
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        }
        return map;
    }

}
