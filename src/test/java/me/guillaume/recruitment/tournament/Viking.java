package me.guillaume.recruitment.tournament;

public class Viking extends Worrior {
    public Viking() {
        super(120, new Axe());
    }

    public Viking equip(String item) {
        return (Viking) super.equip(item);
    }
}
