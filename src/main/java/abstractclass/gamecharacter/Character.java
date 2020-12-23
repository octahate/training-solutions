package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint = 100;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        this.random = random;
    }

    public boolean isAlive (){
        return (hitPoint > 0);
    }

    protected int getActualPrimaryDamage(){
        return random.nextInt(11);
    }

    protected int getActualPrimaryDefence(){
        return random.nextInt(6);
    }

    protected void hit(Character enemy, int damage){
      int defence = enemy.getActualPrimaryDefence();
      if (defence < damage){
          enemy.decreaseHitPoint(damage);
      }
    }
    public void primaryAttack(Character enemy){
        enemy.hit(enemy, enemy.getActualPrimaryDamage());
    }

    private void decreaseHitPoint(int diff){
        hitPoint = hitPoint - diff;
    }

    abstract public void secondaryAttack(Character enemy);
}
