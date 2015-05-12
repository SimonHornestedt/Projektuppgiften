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

    
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String  slot, type, id;
    public Cloth(String n, int defense, int weight, int cost, String slot, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.type = "Cloth";
        this.id = id;
        this.slot = slot;
        this.lvlReq = req;
    }
    public Cloth(String n){
        super(n);
        
        
    }
    @Override
    public int getSpd(){
        return speed;
    }
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot + ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
    @Override
    public Armor createArmor(int i ) {
        Armor arm;
        switch(i){
            case 1:
                arm = new Cloth("Wool Bandages", 3,  2, 100, "Chest" , "1", 1);
            break;
            case 2:
                arm = new Cloth("Worn Bracelet", 1,  2, 50, "Arm", "2", 1);
            break;
            case 3:
                arm = new Cloth("Trousers", 2, 2, 70, "Legs", "3", 1);
            break;
            case 4:
                arm = new Cloth("Mudstained Wrappings", 1, 2, 50, "Feet", "4", 1);
            break;
            default:
                arm = new Cloth("Bloodstained Headband", 2, 2, 55, "Head", "0", 1);
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