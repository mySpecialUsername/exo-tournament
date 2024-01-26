package me.guillaume.recruitment.tournament.body_protection;

import me.guillaume.recruitment.tournament.weapon.Weapon;

public class Armor extends BodyProtection{

    @Override
    public int reduceRecievedDamage(int damage) {
        if (damage >= 3) 
            damage -= 3;
        return damage;
    }

    @Override
    public int reduceDeliveredDamage(Weapon weapon) {
        int damage = weapon.damage();
        if (damage >= 1 ) 
            damage -= 1;
        return damage;
    }
}
