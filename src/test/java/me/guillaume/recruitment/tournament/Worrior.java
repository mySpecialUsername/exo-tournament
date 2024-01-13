package me.guillaume.recruitment.tournament;

public abstract class Worrior {
    protected int hitPoints;
    protected Weapon weapon;
    protected ParryTool parryTool;
    protected BodyProtection bodyProtection;


    public Worrior(int hitPoints, Weapon weapon) {
        this.hitPoints = hitPoints;
        this.weapon = weapon;
        this.parryTool = new ParryTool();
        this.bodyProtection = new BodyProtection();
    }

    public void engage(Worrior opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            if (opponent.recieveHit(this))
                break;
            this.recieveHit(opponent);
        }
    }

    public int produceHit() {
        return this.bodyProtection.reduceDeliveredDamage(this.weapon);
    }

    public boolean recieveHit(Worrior opponent) {
        int damage = opponent.produceHit();
        if (this.tryToParry(opponent.weapon)){
            return false;
        }
        
        damage = this.bodyProtection.reduceRecievedDamage(damage);
        
        if (this.hitPoints > damage){
            this.hitPoints -= damage;
            return false;
        }
        else {
            this.hitPoints = 0;
            return true;
        }
    }

    public boolean tryToParry(Weapon weapon) {
        return this.parryTool.tryToParry(weapon);
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
