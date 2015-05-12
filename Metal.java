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

    
    protected int speed, attack, defense, cost, weight, lvlReq;
    protected String id, slot, type;
    public Metal(String n, int defense,  int weight, int cost, String slot , String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.id = id;
        this.type = "Metal";
        this.slot = slot;
         this.lvlReq = req;
    }
    public Metal(String n){
        super(n);
        
        
    }
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
    @Override
    public int getSpd(){
        return speed;
    }
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    @Override
    public Armor createArmor(int i ) {
        Armor arm;
        switch(i){
            case 1:
                arm = new Metal("Plated Chestpiece", 5, 6, 800,  "Chest",  "1", 10);
            break;
            case 2:
                arm = new Metal("Plated Pauldrons", 3, 5, 300,  "Arm",  "2", 10);
            break;
            case 3:
                arm = new Metal("Iron Leggings", 4,  5, 450, "Legs", "3", 10);
            break;
            case 4:
                arm = new Metal("Hardned Metal Shoes", 3, 5, 300, "Feet", "4", 10);
            break;
            default:
                arm = new Metal("Horned Iron Helm", 6, 5, 900,  "Head" , "0", 10);
            break;
        }
        return arm;
    }

    @Override
    public String getInfo() {
        String info = name +" \nLevel requirement: " + lvlReq +"\nAttack: " + attack + "\nSpeed: " + speed + "\nCost: " +cost;
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
    public String getSlot() {
        return slot;
    }
    @Override
    public String toSaveString() {
        return type + ", " + id;
    }
    @Override
    public int getDefense() {
        return defense;
    }

    
    
}
