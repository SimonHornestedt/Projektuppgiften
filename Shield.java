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
    protected String info;
    public Shield(String n, int attack, int defense,  int speed, int weight, int cost, String info){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        
    }
    public Shield(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + "Shield"+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    public Shield createWeapon(int i ) {
        Shield wep;
        switch(i){
            case 1:
                wep = new Shield("Roman Shield", 20, 45, 23, 80, 60, "asdsdas");
            break;
            default:
                wep = new Shield("Round Shield", 35, 20, 23, 40, 30, "asdasd");
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
}
