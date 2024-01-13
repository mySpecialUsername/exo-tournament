package me.guillaume.recruitment.tournament;

public class Swordsman extends Worrior {
    public Swordsman() {
        super(100, new Sword());
    }

    public Swordsman equip(String item) {
        return (Swordsman) super.equip(item);
    }
}
