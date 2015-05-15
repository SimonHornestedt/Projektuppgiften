




/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public abstract class Character{
    
    /**
     * Medlemsvariabler
     */
    protected String name;
    
    /**
     * Konstruktor till den abstrakta klassen Character
     * @param n är en sträng med Karaktärens namn
     */
    public Character(String n){
        this.name = n;
    }
    
    /**
     * Sätter det nya HP:t då någon gör skada på en karaktär
     * @param dmg int med antal skadepoäng
     */
    public abstract void setNewHP(int dmg);
    
    /**
     * Hämtar Speed från karaktäreren
     * 
     * @return int med snabbheten hos karaktären 
     */
    public abstract int getSpd();
    
    /**
     * Hämtar absorb från karaktär
     * @return int med hur mycket absorb en karaktär har
     */
    public abstract int getAbs();
    
    /**
     * Hämtar namnet från Karaktären
     * @return Sträng med namnet
     */
    public abstract String getName();
    
    /**
     * Kontrollerar om karaktären lever
     * @return boolean för levande(true) eller död(false)
     */
    public abstract boolean isAlive();
   
    
}   
