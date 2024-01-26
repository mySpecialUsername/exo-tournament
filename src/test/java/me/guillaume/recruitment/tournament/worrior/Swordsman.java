package me.guillaume.recruitment.tournament.worrior;


import me.guillaume.recruitment.tournament.weapon.Sword;

public class Swordsman extends Worrior {
    public Swordsman() {
        super(100, new Sword(), "Ordinary");
    }

    public Swordsman(String kind) {
        super(100, new Sword(), kind);
    }

    public Swordsman equip(String item) {
        super.equip(item);
        if (this.kind.equals("Vicious")){
            if (item.equals("axe") || item.equals("greatsword") || item.equals("sword")){
                this.weapon.applyPoison();
            }
        }
        return this;
    }

    @Override
    public void hitLanded() {
        if (this.kind.equals("Vicious")){
            this.weapon.usePoison();
        }
    }
}
