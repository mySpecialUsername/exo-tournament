package me.guillaume.recruitment.tournament;

public class Buckler {
    private int durability;
    private int parryAttempts = 0;

    public Buckler() {
        this.durability = 3;
    }

    public boolean isDestroyed() {
        return this.durability <= 0;
    }

    public int tryToParry(Weapon weapon) {
        this.parryAttempts++;
        if (this.parryAttempts % 2 == 0 && this.durability > 0) {
            if (weapon.kind.equals("axe"))
                durability -= 1;
            return 0;
        }
        return weapon.damage;
    }
}
