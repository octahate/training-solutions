package exampractice;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    List<CanoeRental> canoeRentals = new ArrayList<>();

    public void addRental(CanoeRental canoe){
        if (canoe != null){
            canoeRentals.add(canoe);
        }
    }

    public String findRentalByName(String name){
        for (CanoeRental currentCanoe: canoeRentals){
            if (currentCanoe.getName().equals(name) && currentCanoe.getEndTime() == null){
                return currentCanoe.toString();
            }
        }
        throw new IllegalArgumentException("Can not find canoe!");
    }


    public String closeRentalByName(String name, LocalDateTime endTime){
        for (CanoeRental currentCanoe: canoeRentals){
            if (currentCanoe.getName().equals(name) && currentCanoe.getEndTime() == null){
                currentCanoe.setEndTime(endTime);
            }
        }
        throw new IllegalArgumentException("Can not find canoe!");
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime){
        for (CanoeRental currentCanoe: canoeRentals){
            if (currentCanoe.getName().equals(name) && currentCanoe.getEndTime() == null){
                currentCanoe.calculateRentalSum(endTime);
            }
        }
        throw new IllegalArgumentException("Can not find canoe!");
    }

    public List<CanoeRental> listClosedRentals(){
        List<CanoeRental> result = new ArrayList<>();
        for (CanoeRental currentCanoe: canoeRentals){
            if (currentCanoe.getEndTime() != null){
                result.add(currentCanoe);
            }
        }
        Collections.sort(result);
        return result;
    }

    public Map<CanoeType,Integer> countRentals() {
        Map <CanoeType,Integer> countRentals = new TreeMap<>();
        for (CanoeRental currentCanoe : canoeRentals) {
            if (!countRentals().containsKey(currentCanoe.getCanoeType())) {
                countRentals.put(currentCanoe.getCanoeType(), 0);
            }
            countRentals.put(currentCanoe.getCanoeType(), countRentals.get(currentCanoe.getCanoeType()) + 1);
        }
        return countRentals;
    }

}



