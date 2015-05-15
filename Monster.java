/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class Monster extends Character {
    /**
     * Medlemsvariabler
     */
    protected int speed, dmg, HP, expReward, goldReward, crit, abs, miss;
    
    /**
     * Konstruktor till klassen Monster
     * @param n namnet
     */
    
    public Monster(String n){
        super(n);
        
    }
    
    /**
     * Konstruktor till klassen Monster
     * @param n Namn
     * @param spd snabbhet
     * @param dmg skada
     * @param def försvar/absorb
     * @param HP HealthPoints
     * @param crit Critchans
     * @param exp exp belöning för vinst 
     * @param gold guld belöning för vinst
     * @param miss miss chans
     */
    public Monster(String n, int spd, int dmg, int def, int HP, int crit, int exp, int gold, int miss){
        super(n);
        this.crit = crit;
        this.speed = spd;
        this.dmg = dmg;
        this.abs = def;
        this.HP = HP;
        this.expReward = exp;
        this.goldReward = gold;
        this.miss = miss;
    }
    
    /**
     * Hämtar exp belöningen
     * @return int med exp belöning
     */
    public int getExpReward() {
        return expReward;
    }
    
    /**
     * Hämtar guld belöningen
     * @return int med guld belöning
     */
    public int getGoldReward() {
        return goldReward;
    }
    
    /**
     * Hämtar snabbhet hos monstret
     * @return int med snabbheten
     */
    public int getSpd() {
        return speed;
    }
    
    /**
     * Hämtar skadan hos monstret
     * @return int med skadan
     */
    public int getDmg() {
        return dmg;
    }
    
    /**
     * Hämtar hp hos monstret
     * @return int med HP
     */
    public int getHP() {
        return HP;
    }
    
    /**
     * Hämtar crit chans hos monstret
     * @return int med crit chansen
     */
    public double getCrit() {
        return crit;
    }
    
    /**
     * Hämtar absorb hos monstret
     * @return int med absorb
     */
    @Override
    public int getAbs() {
        return abs;
    }
    
   /**
    * Skapar ett monster
    * @param i det monster man vill 
    * @return det skapade monstret
    */
    public Monster createCharacter(int i) {
       Monster m = null;
        switch(i){
            case 1:
                m = new Monster("Dwarf", 20, 7, 3, 25, 95, 45, 35, 8);
            break;
            case 0:
                m = new Monster("Goblin", 15, 4, 1, 20, 99, 20, 15, 10);
            break;
            case 2:
                m = new Monster("Troll", 45, 8, 5, 30, 90, 50, 60, 6);
            break;
            case 3:
                m = new Monster("Elemental", 30, 15, 30, 35,  85, 100, 40, 8);
            break;
            case 4:
                m = new Monster("Nerubian", 60, 12, 15, 25, 70, 85, 200,3);
            break;
            case 5:
                m = new Monster("Giant", 1, 25, 15, 60, 90, 350, 200 , 15);
            break;
            case 6:
                m = new Monster("Arthis the Lich Queen", 100, 50, 20, 100, 50, 1000, 500, 1);
            break;
            default:
               
            break;
       }
        
        return m;
    }
    
    /**
     * Hämtar monstrets namn
     * @return Sträng men namnet
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Hämtar monstrets chans att missa
     * @return int med misschansen
     */
    public int getMiss(){
        return miss;
    }
    
    /**
     * kontrollerar om mosntret lever
     * @return boolean true om det lever, false om det är dött
     */
    @Override
    public boolean isAlive() {
        if(HP <= 0){
            return false;
        }else{
            return true;
        }  
    }
    
    /**
     * Sätter nytt hp baserat på inkommande skada
     * @param dmg inkommande skada
     */
    @Override
    public void setNewHP(int dmg) {
        if(dmg > 0){
           HP -=dmg;
        }
    }

    
}
