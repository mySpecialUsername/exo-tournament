package me.guillaume.recruitment.tournament.parry_tool;

import me.guillaume.recruitment.tournament.weapon.Weapon;

public class Buckler extends ParryTool {
    private int durability;
    private int parryAttempts = 0;

    public Buckler() {
        this.durability = 3;
    }

    @Override
    public boolean isFunctional() {
        return this.durability > 0;
    }

    public boolean tryToParry(Weapon weapon) {
        boolean success;
        if (this.parryAttempts % 2 == 0 && this.isFunctional()) {
            if (weapon.kindIs("axe"))
                durability -= 1;
            success = true;
        }
        else {
            success = false;
        }
        this.parryAttempts++;
        return success;
    }
}
