package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private List<Ride> rideList = new ArrayList<>();

    public void addRide (Ride newRide){
        if (rideList.isEmpty()){
            isItTheFirstRide(newRide);
        } else {
            Ride lastRide = rideList.get(rideList.size()-1);
            if (isItOnTheSameDay(lastRide,newRide) && (lastRide.getRideNumber() == newRide.getRideNumber()+1)){
                    rideList.add(newRide);
                }
            else throw new IllegalArgumentException ("Wrong parameters!");
        }
    }

    public int returnHoliday(){
        for (int i = 0; i < rideList.size(); i++) {
            if (rideList.get(i).getDayNumber()+1 != rideList.get(i+1).getDayNumber()){
                return rideList.get(i).getDayNumber()+1;
            }
        }
        return 0;
    }


    private boolean isItOnTheSameDay(Ride prevRide, Ride currentRide){
        return (currentRide.getDayNumber() == prevRide.getDayNumber());
    }

    private boolean isItTheFirstRide(Ride currentRide){
        if (currentRide.getRideNumber() != 1){
            throw new IllegalArgumentException("The ride is not the first of the day!");
        } else return true;
    }


}
