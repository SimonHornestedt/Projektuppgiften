
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Monster extends Character implements Comparable{
    protected int speed, dmg, HP, expReward, goldReward;
    private double crit, abs;
    
    
    public Monster(String n){
        super(n);
        
    }
    public Monster(String n, int spd, int dmg, int def, int HP, int crit, int exp, int gold){
        super(n);
        this.crit = crit;
        this.speed = spd;
        this.dmg = dmg;
        this.abs = def;
        this.HP = HP;
        this.expReward = exp;
        this.goldReward = gold;
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }
    
    public int getSpeed() {
        return speed;
    }

    public int getDmg() {
        return dmg;
    }

    public int getHP() {
        return HP;
    }

    public double getCrit() {
        return crit;
    }

    public double getAbs() {
        return abs;
    }
    
    
    @Override
    public String toString() {
        return name; 
    }
    
    public Monster createCharacter(int i) {
       Monster m = null;
        switch(i){
            case 1:
                m = new Monster("Dwarf", 20, 7, 3, 25, 95, 45, 35);
            break;
            case 0:
                m = new Monster("Goblin", 15, 4, 1, 20, 99, 20, 15);
            break;
            case 2:
                m = new Monster("Troll", 45, 8, 5, 30, 90, 50, 60);
            break;
            case 3:
                m = new Monster("Elemental", 30, 15, 30, 35,  85, 100, 40);
            break;
            case 4:
                m = new Monster("Nerubian", 60, 12, 15, 25, 70, 85, 200);
            break;
            case 5:
                m = new Monster("Giant", 1, 25, 15, 60, 90, 350, 200);
            break;
            case 6:
                m = new Monster("Arthis the Lich Queen", 100, 50, 20, 100, 50, 1000, 500);
            break;
            default:
               
            break;
       }
        
        return m;
    }
    public Character getCharacters() {
        return this;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public boolean isAlive() {
        if(HP <= 0){
            return false;
        }else{
            return true;
        }  
    }
    @Override
    public boolean critHits(){
        Random die = new Random();
        
        int r = die.nextInt(100) +1;
        return r > crit;
    }
}
