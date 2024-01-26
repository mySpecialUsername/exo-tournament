package me.guillaume.recruitment.tournament.weapon;

public abstract class Weapon {
    private int damage;
    protected String kind;
    protected int poisonDurability = 0;

    public Weapon(int damage, String kind) {
        this.damage = damage;
        this.kind = kind;
    }

    public boolean kindIs(String kind) {
        return this.kind.equals(kind);
    }

    public boolean tryToStrike() {
        return true;
    }

    public int damage() {
        return this.damage + poisonDamage();
    }

    public int poisonDamage() {
        int res;
        if (this.poisonDurability > 0) {
            res = 20;
        }
        else {
            res = 0;
        }
        return res;
    }

    public void usePoison() {
        if (this.poisonDurability > 0) {
            this.poisonDurability--;
        }
    }

    public void applyPoison() {
        this.poisonDurability = 2;
    }

}
