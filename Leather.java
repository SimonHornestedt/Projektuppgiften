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

    
    protected int speed, attack, defense, cost,weight , lvlReq;
    protected String slot, id, type;
    public Leather(String n, int defense,  int weight, int cost,  String slot, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.type = "Leather";
        this.id = id;
        this.slot = slot;
        this.lvlReq = req;
    }
    public Leather(String n){
        super(n);
        
        
    }
    @Override
    public int getSpd(){
        return speed;
    }
    @Override
    public int getLvlReq() {
        return lvlReq;
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
                arm = new Leather("Blackned Leather Chestguard", 4,  4, 250, "Chest", "1", 5);
            break;
            case 2:
                arm = new Leather("Blackned Leather Armguard", 2, 2, 180, "Arm", "2", 5);
            break;
            case 3:
                arm = new Leather("Blackned Leather Leggings", 3, 3, 230, "Legs", "3", 5);
            break;
            case 4:
                arm = new Leather("Blackned Leather Shoes", 2, 2, 180, "Feet", "4", 5);
            break;
            default:
                arm = new Leather("Blackned Leather Hood", 3,  2, 220, "Head", "0", 5);
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
