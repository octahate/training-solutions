package maturay19s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CarMain {

    public List<CarData> carDatabase = new ArrayList<>();
    public Map<String, Integer> amountOfKilometers = new TreeMap<>();

    public List<CarData> getCarDatabase() {
        return carDatabase;
    }

    public void readFromString(String name) {
        Path path = Path.of(name);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] currentData = line.split(" ");
                CarData currentCar = new CarData(currentData);
                carDatabase.add(currentCar);
                putSizeToMap(currentCar.getCarId(), currentCar.getKilometerCounter());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read line!", e);
        }
    }

    private int returnStartValue(String carId) {
        for (CarData currentCar : carDatabase) {
            if (currentCar.getCarId().equals(carId)) {
                return currentCar.getKilometerCounter();
            }
        }
        throw new IllegalArgumentException("No such car in the database!");
    }

    private void putSizeToMap(String car, int kilometer) {
        if (!amountOfKilometers.containsKey(car)) {
            amountOfKilometers.put(car, kilometer);
        }
        if (amountOfKilometers.get(car) != kilometer) {
            amountOfKilometers.put(car, kilometer);
        }
    }

    public String lastCarTakeOut() {
        for (int i = carDatabase.size() - 1; i > 0; i--) {
            if (carDatabase.get(i).getIsItOut() == 0) {
                return carDatabase.get(i).getDay() + ". nap rendszám: " + carDatabase.get(i).getCarId();
            }
        }
        return "Minden autó bennt van!";
    }

    public void statisticsOfTheDay(int day) {
        for (CarData currentData : carDatabase) {
            if (currentData.getDay() == day) {
                System.out.println(currentData.statistics());
            }
        }
    }

    public void printStaticstics() {
        for (String currentCar : amountOfKilometers.keySet()) {
            System.out.print(currentCar + " ");
            System.out.print((amountOfKilometers.get(currentCar) - returnStartValue(currentCar)));
            System.out.print(" km \n");
        }
    }

    public void longestDistance() {
        int specificPerson = 0;
        int amountOfKm = 0;
        for (int i = 0; i < carDatabase.size(); i++) {
            if (carDatabase.get(i).getIsItOut() == 1) {
                for (int j = i; j > 0; j--) {
                    if (carDatabase.get(j).getIsItOut() == 0 && carDatabase.get(j).getCarId().equals(carDatabase.get(i).getCarId())) {
                        int temp = carDatabase.get(i).getKilometerCounter() - carDatabase.get(j).getKilometerCounter();
                        if (amountOfKm < temp) {
                            specificPerson = carDatabase.get(j).getPersonId();
                            amountOfKm = temp;
                        }
                    }
                }
            }
        }
        System.out.println("Leghosszabb út:" + amountOfKm + " km, személy:" + specificPerson);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarMain cm = new CarMain();
        cm.readFromString("src/main/java/maturay19s1/autok.txt");
        System.out.println(cm.getCarDatabase().size());
        for (CarData currentCar : cm.getCarDatabase()) {
            System.out.println(currentCar.statistics());
        }
        for (String key : cm.amountOfKilometers.keySet()) {
            System.out.println(cm.amountOfKilometers.get(key));
        }
        System.out.println("2. feladat");
        System.out.println(cm.lastCarTakeOut());
        System.out.println("3. feladat");
        System.out.println("Nap:");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Forgalom a(z)" + day + " napon:");
        cm.statisticsOfTheDay(day);
        System.out.println("5. feladat");
        cm.printStaticstics();
        System.out.println("6.feladat");
        cm.longestDistance();
    }
}
