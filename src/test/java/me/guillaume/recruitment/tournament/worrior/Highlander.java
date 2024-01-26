package me.guillaume.recruitment.tournament.worrior;

import me.guillaume.recruitment.tournament.weapon.GreatSword;

public class Highlander extends Worrior {
    
    public Highlander() {
        super(150, new GreatSword(), "Ordinary");
    }

    public Highlander(String kind) {
        super(150, new GreatSword(), kind);
    }

    // @Override
    // public boolean attackAndKill(Worrior opponent) {
    //     if (this.hitPoints <= 50){
    //         if (this.kind.equals("Veteran")){
    //             if (opponent.recieveStrikeAndDie(this))
    //                 return true;
    //         }
    //     }
    //     return opponent.recieveStrikeAndDie(this);
    // }

    @Override
    public int produceDamage() {
        int damage = this.bodyProtection.reduceDeliveredDamage(this.weapon);
        if (this.hitPoints < 50){
            if (this.kind.equals("Veteran")){
                damage *= 2;
            }
        }
        return damage;
    }

    public Highlander equip(String item) {
        super.equip(item);
        return this;
    }
}
