package math.game;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;
    private Point position;

    public Warrior(String name) {
        this.name = name;
    }

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }
    public void move(Warrior warrior){
        warrior.name = this.name;
    }
}
