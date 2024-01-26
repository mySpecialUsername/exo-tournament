package me.guillaume.recruitment.tournament.weapon;

public class GreatSword extends Weapon {
    public int strikeCount = 0;

    public GreatSword() {
        super(12, "greatsword");
    }

    @Override
    public boolean tryToStrike() {
        boolean success;
        if (strikeCount % 3 == 0) {
            success = false;
        }
        else {
            success = true;
        }
        strikeCount++;
        return success;
    }
}
