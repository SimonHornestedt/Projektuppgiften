/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Leather extends Armor{

    
    protected int speed, attack, defense, cost,weight;
    protected String info, slot;
    public Leather(String n, int attack, int speed, int weight, int cost, String info, String slot){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = slot;
    }
    public Leather(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Leather createArmor(int i ) {
        Leather arm;
        switch(i){
            case 1:
                arm = new Leather("Blackned Leather Chestguard", 20, 45, 80, 60, "Leather chestguard", "Chest");
            break;
            case 2:
                arm = new Leather("Blackned Leather Armguard", 35, 20, 40, 30, "Leather armguard", "Arm");
            break;
            case 3:
                arm = new Leather("Blackned Leather Leggings", 45, 30, 50, 40, "Leather legguards", "Legs");
            break;
            case 4:
                arm = new Leather("Blackned Leather Shoes", 35, 20, 40, 30, "Leather shoes", "Feet");
            break;
            default:
                arm = new Leather("Blackned Leather Hood", 35, 20, 40, 30, "Leather headguard", "Head");
            break;
        }
        return arm;
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
