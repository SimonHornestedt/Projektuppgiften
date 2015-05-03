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
    protected String info, slot;
    public Metal(String n, int attack, int speed, int weight, int cost, String info, String slot){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = slot;
    }
    public Metal(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Metal createArmor(int i ) {
        Metal arm;
        switch(i){
            case 1:
                arm = new Metal("Blackned Chestguard", 20, 45, 80, 60, "asdsdas", "Chest");
            break;
            case 2:
                arm = new Metal("Blackned Armguard", 35, 20, 40, 30, "asdasdasd", "Arm");
            break;
            case 3:
                arm = new Metal("Blackned Leggings", 45, 30, 50, 40, "asdad", "Legs");
            break;
            case 4:
                arm = new Metal("Blackned Shoes", 35, 20, 40, 30, "asda", "Feet");
            break;
            default:
                arm = new Metal("Blackned Hood", 35, 20, 40, 30, "asdasd", "Head");
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
