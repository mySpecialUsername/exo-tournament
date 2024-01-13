package me.guillaume.recruitment.tournament;

public abstract class Weapon {
    private int damage;
    protected String kind;

    public Weapon(int damage, String kind) {
        this.damage = damage;
        this.kind = kind;
    }

    public int damage() {
        return this.damage;
    }

    

}
