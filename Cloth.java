/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class Cloth extends Armor{

    /**
     * Medlemsvariabler
     */
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String  slot, type, id;
    
    /**
     * Konstruktor för klassen Cloth
     * @param n namnet på rutningen
     * @param defense försvarspoäng
     * @param weight vikt
     * @param cost kostnad
     * @param slot plats
     * @param id skapelseid 
     * @param req kravlevel
     */
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
    
    /**
     * Dummykonstruktor för klassen Cloth
     * @param n namnet på rustningen
     */
    public Cloth(String n){
        super(n); 
    }
    
    /**
     * hämtar kravleveln
     * @return int med kravlevel 
     */
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
    
    /**
     * hämtar snabbhet
     * @return int med snabbhet
     */
    @Override
    public int getSpd(){
        return speed;
    }
    
    /**
     * Skriver ut rustningen som en sträng
     * @return Sträng med full info om rustningen
     */
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    /**
     * Skapar rustning
     * @param i rustningen som man vill skapa
     * @return den skapade rustningen
     */
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
    
    /**
     * Hämtar info om rustningen
     * @return sträng med Info
     */
    @Override
    public String getInfo() {
        String info = name +" \nLevel requirement: " + lvlReq +"\nDefense: " + defense + "\nSpeed: " + speed + "\nCost: " +cost;
        return info;
    }
    
    /**
     * Hämtar kostnaden
     * @return int med kostnaden
     */
    @Override
    public int getCost() {
        return cost;
    }
    
    /**
     * hämtar namnet
     * @return Sträng med namnet
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Hämtar platsen
     * @return sträng med platsen
     */
    @Override
    public String getSlot() {
        return slot;
    }
    
    /**
     * Skriver rustningen som en sträng man kan spara
     * @return Sträng innehållande nödvändig info för sparning, typ och plats
     */
    @Override
    public String toSaveString() {
        return type + ", " + id;
    }
    
    /**
     * Hämtar försvarspoäng
     * @return försvars poäng
     */
    @Override
    public int getDefense() {
        return defense;
    }
}