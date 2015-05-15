/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public abstract class Weapon {
    /**
     * Medlemsvariabler
     */
    protected String name, info;
    
    /**
     * Konstruktor för klassen Weapon
     * @param n namnet på vapnet
     */
    public Weapon(String n){
        this.name = n;
        
    }
    
    /**
     * Hämtar info om vapnet
     * @return Sträng med information om vapnet
     */
    public abstract String getInfo();
    
    /**
     * Hämtar kostnaden
     * @return int kostnaden
     */
    public abstract int getCost();
    
    /**
     * Hämtar hela vapnet som en sträng
     * @return Sträng med hela vapnet
     */
    @Override
    public abstract String toString();
    
    /**
     * Hämtar namnet
     * @return sträng med namnet
     */
    public abstract String getName();
    
    /**
     * Hämtar stats från vapnet
     * @return int [] med statsen
     */
    public abstract int[] getStats();
    
    /**
     * Hämtar vapnets plats
     * @return sträng med platsen
     */
    public abstract String getSlot();
    
    /**
     * hämtar vapnet som en sträng man kan spara, med de värden som behövs.
     * @return Sträng med information om plats och typ.
     */
    public abstract String toSaveString();
    
    /**
     * Skapar ett vapen
     * @param i vilket vapen som ska skapas
     * @return det skapade vapnet
     */
    public abstract Weapon createWeapon(int i);
    
    /**
     * Hämtar vapnets attack
     * @return int attack
     */
    public abstract int getAttack();
    
    /**
     * Hämtar snabbheten
     * @return int snabbheten
     */
    public abstract int getSpd();
    
    /**
     * Hämtar vapnets försvar
     * @return int vapnets försvar
     */
    public abstract int getDef();
    
    /**
     * Hämtar vapnets kravlevel
     * @return int vapnets kravlevel
     */
    public abstract int getLvlReq();
}