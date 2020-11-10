package week3;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private long bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {

        Position first = new Position("Béla", 160_000);
        Position second = new Position("Józsi", 200_000);
        Position third  = new Position("Anna", 75_000);
        Position fourth = new Position("Laci", 80_000);


        List<Position> positions = new ArrayList<>();

        positions.add(first);
        positions.add(second);
        positions.add(third);
        positions.add(fourth);

        for (int i = 0; i < positions.size(); i++){
            if (positions.get(i).bonus >150000) {
                System.out.println(positions.get(i));
            }
        }



    }
}