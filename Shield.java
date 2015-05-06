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
    protected int speed, attack, defense, cost, weight;
    protected String info, slot, id;
    public Shield(String n,  int defense,  int weight, int cost, String info, String id){
        super(n);
        this.speed = (int)(weight * 0.2);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "Shield";
        this.id = id;
        
    }
    public Shield(String n){
        super(n);
        
        
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
                wep = new Shield("Roman Shield", 120, 200, 400, "asdsdas", "1");
            break;
            default:
                wep = new Shield("Round Shield", 70, 100, 80, "asdasd", "0");
            break;
        }
        return wep;
    }

    @Override
    public String getInfo() {
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
}