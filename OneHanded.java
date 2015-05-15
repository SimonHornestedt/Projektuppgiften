/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class OneHanded extends Weapon{
    
    /**
     * Medlemsvariabler
     */
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String info, slot, id;
    
    /**
     * Konstruktor för klassen OneHanded
     * @param n namnet
     * @param attack attack
     * @param weight vikten
     * @param cost kostnaden
     * @param id skapelse id
     * @param req kravLevel
     */
    public OneHanded(String n, int attack,  int weight, int cost, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = "";
        this.slot = "1-Handed";
        this.id = id;
        this.lvlReq = req;
    }
    
    /**
     * Kosntruktor som skapar ett Dummy vapen som sedan skrivs över.
     * @param n dummynamn
     */
    public OneHanded(String n){
        super(n);           
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
     * Hämtar hela vapnet som en sträng
     * @return Sträng med hela vapnet
     */
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
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
                wep = new OneHanded("Small Basic Mace", 10,  5, 100, "1" , 1);
            break;
            case 2:
                wep = new OneHanded("Basic Dagger", 10, 3, 100, "2", 1);
            break;
            case 3:
                wep = new OneHanded("Shadowmourne", 35,  8, 300 ,"3", 8);
            break;
            case 4:
                wep = new OneHanded("Angmar", 60,  15, 300, "4", 10);
            break;
            case 5:
                wep = new OneHanded("Fangs of the Father", 35,  1, 300, "5", 6);
            break;
            default:
                wep = new OneHanded("Basic Axe", 20, 4, 100, "0", 1);
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
