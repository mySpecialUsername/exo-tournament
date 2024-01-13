package me.guillaume.recruitment.tournament;

public class Armor extends BodyProtection{

    @Override
    public int reduceRecievedDamage(int damage) {
        if (damage == 0) 
            return 0;
        return damage - 3;
    }

    @Override
    public int reduceDeliveredDamage(Weapon weapon) {
        int damage = weapon.damage();
        if (damage == 0) 
            return 0;
        return damage - 1;
    }
}
