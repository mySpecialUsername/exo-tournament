package me.guillaume.recruitment.tournament;

public class BodyProtection{

    public int reduceRecievedDamage(int damage) {
        return damage;
    }

    public int reduceDeliveredDamage(Weapon weapon) {
        return weapon.damage();
    }
}
