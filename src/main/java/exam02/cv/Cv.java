package exam02.cv;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skills){
        for (int i = 0; i < skills.length; i++) {
            String currentSkill = skills[i];
            int indexOfColon = findColonPlace(skills[i]);
            String subject = skills[i].substring(0,indexOfColon-1);
            int level = parseInt(skills[i].substring(indexOfColon+1, indexOfColon+2));
            this.skills.add(new Skill(subject,level));
        }
    }

    private int findColonPlace (String text){
        for (int i = 0; i < text.length(); i++) {
            if ('(' == text.charAt(i)){
                return i;
            }
        } throw new IllegalArgumentException("Text is not properly formatted!");
    }

    public int findSkillLevelByName(String skillToFind) {
        for (Skill currentSkill : skills){
            if (currentSkill.getName().equals(skillToFind)){
                return currentSkill.getLevel();
            }
        } throw new IllegalArgumentException("Skill cannot be found!");
    }

}
