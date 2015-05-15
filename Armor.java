
    /**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
    public abstract class Armor {
        
    /**
     * Medlemsvariabler
     */
    protected String name;
    
    /**
     * Konstruktor för klassen Weapon
     * @param n namnet på vapnet
     */
    public Armor(String n){
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
     * Hämtar Rustningens försvar
     * @return int rustningens försvar
     */
    public abstract int getDefense();
    
   /**
     * Hämtar snabbheten
     * @return int snabbheten
     */
    public abstract int getSpd();
    
     /**
     * Hämtar hela rustningen som en sträng
     * @return Sträng med hela rustningen
     */
    @Override
    public abstract String toString();
    
    /**
     * Hämtar rustningens namn
     * @return Sträng med namnet
     */
    public abstract String getName();
    
    /**
     * hämtar rustningens plats
     * @return Sträng rustningens plats
     */
    public abstract String getSlot();
    
    /**
     * hämtar rustningen som en sträng man kan spara, med de värden som behövs.
     * @return Sträng med information om plats och typ.
     */
    public abstract String toSaveString();
    
    /**
     * Skapar ett vapen
     * @param i det vapen som ska skapas
     * @return Det skapade vapnet
     */
    public abstract Armor createArmor(int i);
    
    /**
     * Hämtar rustningens kravlevel
     * @return int rusningens kravlevel
     */
    public abstract int getLvlReq();
}

