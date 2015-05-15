/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class Ring extends Armor{

    /**
     * Medlemsvariabler
     */
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String slot, id;
    
    /**
     * Konstruktor för klassen Ring
     * @param n namnet på rutningen
     * @param attack attackpoäng
     * @param defense försvarspoäng
     * @param weight vikt
     * @param cost kostnad
     * @param speed snabbhet
     * @param id skapelseid 
     * @param req kravlevel
     */
    public Ring(String n, int attack, int defense, int speed, int weight, int cost,  String id, int req ){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.id = id;
        this.slot = "Ring";
        this.lvlReq = req;
        
    }
    
    /**
     * Dummykonstruktor för klassen Ring
     * @param n namnet på rustningen
     */
    public Ring(String n){
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
    public Armor createArmor(int i){
        Armor arm;
        switch(i){
            case 1:
                arm = new Ring("Signet of Speed", 0, 0, 40, 0, 80,  "1", 1);
            break;
            case 2:
                arm = new Ring("Legendary Amulet", 10, 10, 50, 0, 2000, "2", 10);
            break;
            default:
                arm = new Ring("Band of Pain", 20, 0, 0, 0, 80, "0", 5);
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
        String info = name +" \nLevel requirement: " + lvlReq +"\nDefense: " + defense +"\nAttack: " + attack+ "\nSpeed: " + speed + "\nCost: " +cost;
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
        return slot + ", " + id;
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