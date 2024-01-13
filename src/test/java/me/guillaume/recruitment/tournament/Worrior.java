package me.guillaume.recruitment.tournament;

public abstract class Worrior {
    protected int hitPoints;
    protected Buckler buckler;
    protected Weapon weapon;
    // protected Armor armor;


    public Worrior(int hitPoints, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
    }

    public void engage(Worrior worrior) {
        while (this.hitPoints > 0 && worrior.hitPoints > 0) {
            if (worrior.recieveHit(this.weapon))
                break;
            this.recieveHit(worrior.weapon);
        }
    }

    public boolean recieveHit(Weapon weapon) {
        int damage = this.tryToParry(weapon);
        
        if (this.hitPoints > damage){
            this.hitPoints -= damage;
            return false;
        }
        else {
            this.hitPoints = 0;
            return true;
        }
    }

    public int tryToParry(Weapon weapon) {
        int damage;
        if (this.buckler != null)
            damage = this.buckler.tryToParry(weapon);
        else
            damage = weapon.damage;
        return damage;
    }

    public int hitPoints() {
        return this.hitPoints;
    }

    public Worrior equip(String item) {
        if (item.equals("buckler"))
            this.buckler = new Buckler();
        // if (item.equals("armor"))
        //     this.armor = new Armor();
        // if (item.equals("greatsword"))
        //     this.weapon = new GreatSword();
        // if (item.equals("axe"))
        //     this.weapon = new Axe();
        // if (item.equals("sword"))
        //     this.weapon = new Sword();
        return this;
    }

}
