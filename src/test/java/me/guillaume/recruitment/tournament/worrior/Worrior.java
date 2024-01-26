package me.guillaume.recruitment.tournament.worrior;

import me.guillaume.recruitment.tournament.body_protection.Armor;
import me.guillaume.recruitment.tournament.body_protection.BodyProtection;
import me.guillaume.recruitment.tournament.parry_tool.Buckler;
import me.guillaume.recruitment.tournament.parry_tool.ParryTool;
import me.guillaume.recruitment.tournament.weapon.Axe;
import me.guillaume.recruitment.tournament.weapon.GreatSword;
import me.guillaume.recruitment.tournament.weapon.Sword;
import me.guillaume.recruitment.tournament.weapon.Weapon;

public abstract class Worrior {
    protected int hitPoints;
    protected Weapon weapon;
    protected ParryTool parryTool;
    protected BodyProtection bodyProtection;
    protected String kind;
    protected int maxHitPoints;


    public Worrior(int hitPoints, Weapon weapon, String kind) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.parryTool = new ParryTool();
        this.bodyProtection = new BodyProtection();
        this.kind = kind;
        this.maxHitPoints = hitPoints;
        if (kind.equals("Ordinary")) {
            ;
        }
        else if (kind.equals("Vicious")) {
            ;
        }
        else if (kind.equals("Veteran")) {
            ;
        }
        else
            throw new IllegalArgumentException("kind must be 'Vicious', 'Ordinary' or 'Veteran'");
    }

    public void engage(Worrior opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            if (this.attackAndKill(opponent))
                break;
            opponent.attackAndKill(this);
        }
    }

    public boolean attackAndKill(Worrior opponent) {
        return opponent.recieveStrikeAndDie(this);
    }


    public boolean recieveStrikeAndDie(Worrior opponent) {
        boolean success;
        if (!opponent.weapon.tryToStrike())
            success = false;
        else {
            int damage = opponent.produceDamage();

            boolean parried = this.parryTool.tryToParry(opponent.weapon);

            if (parried){
                success = false;
            }
            else {
                opponent.hitLanded();
                damage = this.bodyProtection.reduceRecievedDamage(damage);
                success = this.recieveDamageAndDie(damage);
            }
        }
        return success;
    }

    public int produceDamage() {
        return this.bodyProtection.reduceDeliveredDamage(this.weapon);
    }

    public void hitLanded() {
        ;// the base method does nothing but is overriden in some subclasses
    }

    public boolean recieveDamageAndDie(int damage) {
        if (this.hitPoints > damage){
            this.hitPoints -= damage;
            return false;
        }
        else {
            this.hitPoints = 0;
            return true;
        }
    }

    public int hitPoints() {
        return this.hitPoints;
    }

    public Worrior equip(String item) {
        if (item.equals("buckler"))
            this.parryTool = new Buckler();
        if (item.equals("armor"))
            this.bodyProtection = new Armor();
        if (item.equals("greatsword"))
            this.weapon = new GreatSword();
        if (item.equals("axe"))
            this.weapon = new Axe();
        if (item.equals("sword"))
            this.weapon = new Sword();
        return this;
    }

}
