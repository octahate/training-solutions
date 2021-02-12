package week15d05;

import java.util.Objects;

public class Battle implements Comparable<Battle>{

    String house;
    int count;

    public Battle(String house) {
        this.house = house;
    }

    public void addBattle(){
        count++;
    }

    public String getHouse() {
        return house;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "house='" + house + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battle battle = (Battle) o;
        return Objects.equals(house, battle.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house);
    }

    @Override
    public int compareTo(Battle o) {
        return count-o.getCount();
    }
}
