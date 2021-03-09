package maturay19s1;

import java.time.LocalTime;

public class CarData {
    private int day;
    private LocalTime time;
    private String carId;
    private int personId;
    private int kilometerCounter;
    private int isItOut;

    public CarData(int day, LocalTime time, String carId, int personId, int kilometerCounter, int isItOut) {
        this.day = day;
        this.time = time;
        this.carId = carId;
        this.personId = personId;
        this.kilometerCounter = kilometerCounter;
        this.isItOut = isItOut;
    }

    public CarData(String[] details){
        day = Integer.parseInt(details[0]);
        time = LocalTime.of(Integer.parseInt(details[1].split(":")[0]),Integer.parseInt(details[1].split(":")[1]));
        carId=details[2];
        personId=Integer.parseInt(details[3]);
        kilometerCounter=Integer.parseInt(details[4]);
        isItOut = Integer.parseInt(details[5]);
    }

    public int getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCarId() {
        return carId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getKilometerCounter() {
        return kilometerCounter;
    }

    public int getIsItOut() {
        return isItOut;
    }

    private String isItOutString(int isItOut){
        if (isItOut==0){
            return "ki";
        } else return "be";
    }

    public String statistics(){
        return time + " " + carId + " " + personId + " " + isItOutString(isItOut);
    }
}
