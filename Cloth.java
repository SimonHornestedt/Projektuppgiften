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
    protected String  slot, type, id;
    public Cloth(String n, int defense, int speed, int weight, int cost, String slot, String id){
        super(n);
        this.speed = speed;
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.type = "Cloth";
        this.id = id;
        this.slot = slot;
    }
    public Cloth(String n){
        super(n);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot + ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    @Override
    public Armor createArmor(int i ) {
        Armor arm;
        switch(i){
            case 1:
                arm = new Cloth("Wool Bandages", 5, 30, 5, 10, "Chest" , "1");
            break;
            case 2:
                arm = new Cloth("Worn Bracelet", 5, 20, 10, 10, "Arm", "2");
            break;
            case 3:
                arm = new Cloth("Trousers", 10, 30, 50, 20, "Legs", "3");
            break;
            case 4:
                arm = new Cloth("Mudstained Wrappings", 5, 20, 10, 30, "Feet", "4");
            break;
            default:
                arm = new Cloth("Bloodstained Headband", 5, 45, 15, 45, "Head", "0");
            break;
        }
        return arm;
    }

    @Override
    public String getInfo() {
        return type +" "+  slot;
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