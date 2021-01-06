package exam02.cv;

public class Skill {

    private String name;
    private int level;

    public Skill(String skill, int level) {
        if (level < 1 || level > 5){
            throw new IllegalArgumentException("Skill level must be between 1 and 5!");
        }
        this.name = skill;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
