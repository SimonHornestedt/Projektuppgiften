/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Shield extends Weapon{
    protected int speed, attack, defense, cost, weight, lvlReq;
    protected String info, slot, id;
    public Shield(String n,  int defense,  int weight, int cost, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "Shield";
        this.id = id;
        this.lvlReq = req;
        
    }
    public Shield(String n){
        super(n);
    }
    
    @Override
    public int getSpd(){
        return speed;
    }
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    @Override
    public Weapon createWeapon(int i ) {
        Weapon wep;
        switch(i){
            case 1:
                wep = new Shield("Roman Shield", 10, 10, 400, "1", 7);
            break;
            default:
                wep = new Shield("Round Shield", 4, 5, 80, "0" , 1 );
            break;
        }
        return wep;
    }

    @Override
    public String getInfo() {
        info = name +" \nLevel requirement: " + lvlReq +"\nAttack: " + attack + "\nSpeed: " + speed + "\nCost: " +cost;
        return info;
    }
    @Override
    public int getCost() {
        return cost;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int[] getStats() {
        int[] stats = new int[]{attack, speed, weight};
        return stats;
    }

    @Override
    public String getSlot() {
        return slot;
    }
    
    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    @Override
    public int getAttack() {
        return attack;
    }
    @Override
    public int getDef() {
        return defense;
    }
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
}
