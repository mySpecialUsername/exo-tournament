package me.guillaume.recruitment.tournament;

public class Buckler extends ParryTool {
    private int durability;
    private int parryAttempts = 0;

    public Buckler() {
        this.durability = 3;
    }

    @Override
    public boolean isFunctional() {
        return this.durability > 0;
    }

    public boolean tryToParry(Weapon weapon) {
        this.parryAttempts++;
        if (this.parryAttempts % 2 == 0 && this.isFunctional()) {
            if (weapon.kind.equals("axe"))
                durability -= 1;
            return true;
        }
        return false;
    }
}
