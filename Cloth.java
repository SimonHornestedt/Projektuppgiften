/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Cloth extends Armor{

    
    protected int speed, attack, defense, cost,weight;
    protected String info, slot;
    public Cloth(String n, int attack, int speed, int weight, int cost, String info, String slot){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = slot;
    }
    public Cloth(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot + ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Cloth createArmor(int i ) {
        Cloth arm;
        switch(i){
            case 1:
                arm = new Cloth("Wool Bandages", 20, 45, 80, 60, "Cloth chestguard", "Chest");
            break;
            case 2:
                arm = new Cloth("Worn Bracelet", 35, 20, 40, 30, "Cloth armguards", "Arm");
            break;
            case 3:
                arm = new Cloth("Trousers", 45, 30, 50, 40, "Cloth legguard", "Legs");
            break;
            case 4:
                arm = new Cloth("Mudstained Wrappings", 35, 20, 40, 30, "Cloth shoes", "Feet");
            break;
            default:
                arm = new Cloth("Bloodstained Headband", 35, 20, 40, 30, "Cloth headguard", "Head");
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