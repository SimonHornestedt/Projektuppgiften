/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Metal extends Armor{

    
    protected int speed, attack, defense, cost,weight;
    protected String id, slot, type;
    public Metal(String n, int attack, int speed, int weight, int cost, String slot , String id){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.id = id;
        this.type = "Metal";
        this.slot = slot;
    }
    public Metal(String n){
        super(n);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Armor createArmor(int i ) {
        Armor arm;
        switch(i){
            case 1:
                arm = new Metal("Plated Chestpiece", 20, 45, 80, 60,  "Chest",  "1");
            break;
            case 2:
                arm = new Metal("Plated Pauldrons", 35, 20, 40, 30,  "Arm",  "2");
            break;
            case 3:
                arm = new Metal("Iron Leggings", 45, 30, 50, 40, "Legs", "3");
            break;
            case 4:
                arm = new Metal("Hardned Metal Shoes", 35, 20, 40, 30, "Feet", "4");
            break;
            default:
                arm = new Metal("Horned Iron Helm", 35, 20, 40, 30,  "Head" , "0");
            break;
        }
        return arm;
    }

    @Override
    public String getInfo() {
        return type + " " + slot;
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
    public String getSlot() {
        return slot;
    }
    @Override
    public String toSaveString() {
        return type + ", " + id;
    }
    
}
