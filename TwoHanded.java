/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class TwoHanded extends Weapon{
    
    /**
     * Medlemsvariabler
     */
    protected int speed, attack, defense, cost, weight, lvlReq;
    protected String info, slot, id;
    
    /**
     * Kosntruktor som skapar ett Dummy vapen som sedan skrivs över.
     * @param n dummynamn
     */
    public TwoHanded(String n){
        super(n);
    }
    
    /**
     * Konstruktor för klassen OneHanded
     * @param n namnet
     * @param attack attack
     * @param weight vikten
     * @param cost kostnaden
     * @param id skapelse id
     * @param req kravLevel
     */
    public TwoHanded(String n, int attack,  int weight, int cost,  String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "2-Handed";
        this.id = id;  
        this.lvlReq = req;
    }  
    
    /**
     * Hämtar hela vapnet som en sträng
     * @return Sträng med hela vapnet
     */
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    /**
     * Hämtar snabbheten
     * @return int snabbheten
     */
    @Override
    public int getSpd(){
        return speed;
    }
    
    /**
     * Skapar ett vapen
     * @param i vilket vapen som ska skapas
     * @return det skapade vapnet
     */
    @Override
    public Weapon createWeapon(int i ) {
        Weapon wep;
        switch(i){
            case 1:
                wep = new TwoHanded("Basic Mace", 5,  10, 180, "1", 1);
            break;
            case 2:
                wep = new TwoHanded("Basic Spear", 3, 4, 180,  "2" , 1);
            break;
            case 3:
                wep = new TwoHanded("Frostmourne", 18, 10, 2000, "3",20);
            break;
            case 4:
                wep = new TwoHanded("Sulfuras", 20, 1, 100000, "4", 5);
            break;
            case 5:
                wep = new TwoHanded("Dragon Glavie", 15, 1, 2000, "5", 4);
            break;
            default:
                wep = new TwoHanded("Basic Sword", 4, 5, 180, "0",1);
            break;
        }
        return wep;
    }
    
    /**
     * Hämtar info om vapnet
     * @return Sträng med information om vapnet
     */
    @Override
    public String getInfo() {
        info = name +" \nLevel requirement: " + lvlReq +"\nAttack: " + attack + "\nSpeed: " + speed + "\nCost: " +cost;
        return info;
    }
    
    /**
     * Hämtar kostnaden
     * @return int kostnaden
     */
    @Override
    public int getCost() {
        return cost;
    }
    
    /**
     * Hämtar namnet
     * @return sträng med namnet
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Hämtar stats från vapnet
     * @return int [] med statsen
     */
    @Override
    public int[] getStats() {
        int[] stats = new int[]{attack, speed, weight};
        return stats;
    }
    
    /**
     * Hämtar vapnets försvar
     * @return int vapnets försvar
     */
    @Override
    public int getDef() {
        return defense;
    }
    
    /**
     * Hämtar vapnets plats
     * @return sträng med platsen
     */
    @Override
    public String getSlot() {
        return slot;
    }
    
    /**
     * hämtar vapnet som en sträng man kan spara, med de värden som behövs.
     * @return Sträng med information om plats och typ.
     */
    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    
    /**
     * Hämtar vapnets attack
     * @return int attack
     */
    @Override
    public int getAttack() {
        return attack;
    }
    
    /**
     * Hämtar vapnets kravlevel
     * @return int vapnets kravlevel
     */
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
}
