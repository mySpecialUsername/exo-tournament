package me.guillaume.recruitment.tournament.body_protection;

import me.guillaume.recruitment.tournament.weapon.Weapon;

public class BodyProtection{

    public int reduceRecievedDamage(int damage) {
        return damage;
    }

    public int reduceDeliveredDamage(Weapon weapon) {
        return weapon.damage();
    }
}
