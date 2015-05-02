
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 96simrog
 */
public class Monster extends Character{
    protected int speed, attack, defense, HP;
    ArrayList <Monster> monsterList = new ArrayList<>();
    
    public Monster(String n){
        super(n);
        
    }
    public Monster(String n, int spd, int atk, int def, int HP){
        super(n);
        this.speed = spd;
        this.attack = atk;
        this.defense = def;
        this.HP = HP;
    }
    
    @Override
    public String toString() {
        return name; 
    }
    
    private Monster createCharacter(String name) {
       Monster m = null;
        switch(name){
            case "Dwarf":
                m = new Monster("Dwarf", 20, 45, 80, 60);
            break;
            case "Goblin":
                m = new Monster("Goblin", 35, 20, 40, 30);
            break;
            case "Troll":
                m = new Monster("Troll", 45, 30, 50, 40);
            break;
            case "Elemental":
                m = new Monster("Elemental", 10, 65, 30, 55);
            break;
            case "Nerubian":
                m = new Monster("Nerubian", 85, 35, 25, 40);
            break;
            case "Giant":
                m = new Monster("Giant", 10, 90, 50, 60);
            break;
            case "Lich King":
                m = new Monster("Arthas the Lich King", 101, 101, 101, 101);
            break;
            default:
                
            break;
       }
        if(m!= null){
        monsterList.add(m); 
        }
        return m;
    }
    public ArrayList<Monster> getMonsterList(){
        return monsterList;
    }
    @Override
    public Character getCharacters(String n) {
        for(Monster m: monsterList){
            if(n.equals(m.name)){
                return m;       
            } 
        }
        return createCharacter(n);
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getStats() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStats(String[] posts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
