/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class Shield extends Weapon{
     
    /**
     * Medlemsvariabler
     */
    protected int speed, attack, defense, cost, weight, lvlReq;
    protected String info, slot, id;
    
    /**
     * Konstruktor för klassen Shield
     * @param n namnet
     * @param defense försvars poäng
     * @param weight vikten
     * @param cost kostnaden
     * @param id skapelse id
     * @param req kravLevel
     */
    public Shield(String n,  int defense,  int weight, int cost, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = 0;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "Shield";
        this.id = id;
        this.lvlReq = req;
        
    }
    
    /**
     * Kosntruktor som skapar en Dummy Sköld som sedan skrivs över.
     * @param n dummynamn
     */
    public Shield(String n){
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
     * Hämtar hela skölden som en sträng
     * @return Sträng med hela skölden
     */
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    /**
     * Skapar ett Weapon
     * @param i vilken sköld som ska skapas
     * @return den skapade skölden
     */
    @Override
    public Weapon createWeapon(int i ) {
        Weapon wep;
        switch(i){
            case 1:
                wep = new Shield("Roman Shield", 10, 10, 400, "1", 7);
            break;
            default:
                wep = new Shield("Round Shield", 4, 5, 80, "0" , 1 );
            break;
        }
        return wep;
    }
    
    /**
     * Hämtar info om skölden
     * @return Sträng med information om skölden
     */
    @Override
    public String getInfo() {
        info = name +" \nLevel requirement: " + lvlReq +"\nDefense: " + defense + "\nSpeed: " + speed + "\nCost: " +cost;
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
     * Hämtar stats från skölden
     * @return int [] med statsen
     */
    @Override
    public int[] getStats() {
        int[] stats = new int[]{attack, speed, weight};
        return stats;
    }
    
    /**
     * Hämtar sköldens försvar
     * @return int sköldens försvar
     */
    @Override
    public int getDef() {
        return defense;
    }
    
    /**
     * Hämtar sköldens plats
     * @return sträng med platsen
     */
    @Override
    public String getSlot() {
        return slot;
    }
   
    /**
     * hämtar skölden som en sträng man kan spara, med de värden som behövs.
     * @return Sträng med information om plats och typ.
     */
    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    
    /**
     * Hämtar sköldens attack
     * @return int attack
     */
    @Override
    public int getAttack() {
        return attack;
    }
    
    /**
     * Hämtar sköldens kravlevel
     * @return int sköldens kravlevel
     */
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
}
