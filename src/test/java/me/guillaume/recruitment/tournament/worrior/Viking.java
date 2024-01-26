package me.guillaume.recruitment.tournament.worrior;

import me.guillaume.recruitment.tournament.weapon.Axe;

public class Viking extends Worrior {
    public Viking() {
        super(120, new Axe(), "Ordinary");
    }

    public Viking equip(String item) {
        super.equip(item);
        return this;
    }
}
