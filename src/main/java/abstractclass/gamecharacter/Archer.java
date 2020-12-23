package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character{

    private int numberOfArrow;

    public Archer(Point position, Random random, int numberOfArrow) {
        super(position, random);
        this.numberOfArrow = numberOfArrow;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        ;
    }
}
