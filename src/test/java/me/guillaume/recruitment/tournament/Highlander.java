package me.guillaume.recruitment.tournament;

public class Highlander extends Worrior {
    public Highlander() {
        super(150, new GreatSword());
    }

    public Highlander equip(String item) {
        return (Highlander) super.equip(item);
    }
}
