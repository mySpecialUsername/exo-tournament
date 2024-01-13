package me.guillaume.recruitment.tournament;

public class GreatSword extends Weapon {
    int hitCounter = 0;

    public GreatSword() {
        super(12, "great sword");
    }

    @Override
    public int damage() {
        hitCounter++;
        if (hitCounter % 3 == 0) {
            return 0;
        }
        return super.damage();
    }
}
