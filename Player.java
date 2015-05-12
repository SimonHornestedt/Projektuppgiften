
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;


public class Player extends Character implements Comparable{
    private int agi, str, spd, thg, onehand, twohand, shield, lvl, exp, HP, gold, dmg, defense, attack, wepSkill;
    private double crit, abs ,miss;
    ArrayList <Armor> armorInventory;
    ArrayList <Weapon> wepInventory;
    boolean headEquiped,chestEquiped,armEquiped,legsEquiped,feetEquiped,ringEquiped,shieldEquiped,twoEquiped,oneEquiped;
    ArrayList <Integer> baseStats;
    ArrayList <Weapon> equippedWep;
    ArrayList <Armor> equippedArmor;
    
    
    public Player(String n){
        super(n);
        agi = 10;
        str = 10;
        spd = 10;
        thg = 10;
        onehand = 10;
        twohand = 10;
        shield = 10;
        lvl = 1;
        exp = 0;
        HP = (int) (thg*1.2);
        gold = 200;        
        headEquiped = false;
        chestEquiped = false;
        armEquiped = false;
        legsEquiped = false;
        feetEquiped = false;
        ringEquiped = false;
        shieldEquiped = false;
        twoEquiped = false;
        oneEquiped = false;
        armorInventory = new ArrayList <>();
        wepInventory = new ArrayList <>();
        equippedWep = new ArrayList <>();
        equippedArmor = new ArrayList <>();
        baseStats = new ArrayList <>();
        defense = this.calcDef();
        attack = this.calcAtk();
        abs = defense*0.2;
        wepSkill = this.calcWepSkill();
        miss = 100/wepSkill;
        dmg = (int)((str*0.80) + (agi*0.5) + attack + wepSkill);
        crit = (int)(agi + spd *0.1);
        
    }
    private int calcDef(){
        int def = 0;
        if(!equippedArmor.isEmpty()){
            for(Armor arm : equippedArmor){
                int tmp = arm.getDefense();
                def += tmp;
            }
        }
        return def;
    }
    
    private int calcAtk(){
        int atk = 0;
        if(!equippedWep.isEmpty()){
            for(Weapon wep : equippedWep){
                int tmp = wep.getAttack();
                atk += tmp;
            }
        }
        return atk;
    }
    private int calcWepSkill(){
        int wS = 10;
        if(oneEquiped){
            wS = onehand;
        }else if(twoEquiped){
            wS = twohand;
        }
        return wS;
    }
        
    public Character getCharacters() {
        return this;
    }

    public ArrayList<Weapon> getEquippedWep() {
        return equippedWep;
    }

    public ArrayList<Armor> getEquippedArmor() {
        return equippedArmor;
    }
    public void equipLoadedWeapons(Weapon w){
        String slot = w.getSlot();
        this.equipWeapon(w, slot);
    }
    public void equipLoadedGear(Armor a){
        String slot = a.getSlot();
        this.equipArmor(a, slot);
    }
    public void equipWeapon(Weapon w, String slot){
        System.out.println(w);
        System.out.println(slot);
        switch(slot){
            case "1-Handed":
                if(!oneEquiped ){
                    if(!twoEquiped){
                        equippedWep.add(w);
                        oneEquiped = true;
                        System.out.println("A onehanded has been equiped");
                    }else{ 
                         JOptionPane.showMessageDialog(null, "A twohanded weapon is already equipped, click the picture to unequip.");
                    }
                }else{
                    for(Weapon wep : equippedWep){
                        if(wep.getSlot().equals(slot)){
                            equippedWep.remove(wep);
                            equippedWep.add(w);
                            System.out.println("A onehanded has been replaced");
                            break;
                        }
                    }
                }
            break;
            case "2-Handed":
                if(!twoEquiped ){
                    if(!oneEquiped){
                        equippedWep.add(w);
                        twoEquiped = true;
                        System.out.println("A twohanded has been equiped");
                    }else{ 
                         JOptionPane.showMessageDialog(null, "A onehanded weapon is already equipped, click the picture to unequip.");
                    }
                }else{
                    for(Weapon wep : equippedWep){
                        if(wep.getSlot().equals(slot)){
                            equippedWep.remove(wep);
                            equippedWep.add(w);
                            System.out.println("A twohanded has been replaced");
                            break;
                        }
                    }
                }
            break;
            case "Shield":
                if(!shieldEquiped){
                    if(!twoEquiped){
                        equippedWep.add(w);
                        shieldEquiped = true;
                        System.out.println("A shield has been equiped");
                    }else{ 
                         JOptionPane.showMessageDialog(null, "You can't equip a shield with a twohanded weapon. Please unequip the weapon and try again.");
                    }
                }else{
                    for(Weapon wep : equippedWep){
                        if(wep.getSlot().equals(slot)){
                            equippedWep.remove(wep);
                            equippedWep.add(w);
                            System.out.println("A shield has been replaced");
                            break;
                        }
                    }
                }
            break;
                
        }
        updateStats();
        
    }
    public void equipArmor(Armor a, String slot){
        
        System.out.println(a);
        System.out.println(slot);
        switch(slot){
            case "Head":
               
                    if(!headEquiped){
                        equippedArmor.add(a);
                        headEquiped = true;
                        System.out.println("A helm has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("A helm has been replaced");
                                break;
                            }
                        }
                    }
            break;
            case "Chest":
                
                    if(!chestEquiped){
                        equippedArmor.add(a);
                        chestEquiped = true;
                        System.out.println("A chest has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("A chest has been replaced");
                                break;
                            }
                        }
                    }
            break;
            case "Arm":
                
                    if(!armEquiped){
                        equippedArmor.add(a);
                        armEquiped = true;
                        System.out.println("An arm has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("An arm has been replaced");
                                break;
                            }
                        }
                    }
            break;
            case "Legs":
                
                    if(!legsEquiped){
                        equippedArmor.add(a);
                        legsEquiped = true;
                        System.out.println("legs has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("Legs has been replaced");
                                break;
                            }
                        }
                    }
            break;
            case "Feet":
                
                    if(!feetEquiped){
                        equippedArmor.add(a);
                        feetEquiped = true;
                        System.out.println("A feet has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("feet has been replaced");
                                break;
                            }
                        }
                    }
            break;
            case "Ring":
                
                    if(!ringEquiped){
                        equippedArmor.add(a);
                        ringEquiped = true;
                        System.out.println("A ring has been equiped");
                    }else{ 
                        for(Armor arm : equippedArmor){
                            if(arm.getSlot().equals(slot)){
                                equippedArmor.remove(arm);
                                equippedArmor.add(a);
                                System.out.println("A ring has been replaced");
                                break;
                            }
                        }
                    }
            break;
                
        }
        updateStats();
    }
    public void unequipWeapon(String slot){
                    for(Weapon wep : equippedWep){
                        if(wep.getSlot().equals(slot)){
                            equippedWep.remove(wep);
                            switch(slot){
                                case "Shield":
                                    shieldEquiped = false;
                                break;
                                case "1-Handed":
                                    oneEquiped = false;
                                break;
                                case "2-Handed":
                                    twoEquiped = false;
                                break;
                            }
                             break;
                        }
                    }
                    
    }
   public void unequipArmor(String slot){
                    for(Armor arm : equippedArmor){
                        if(arm.getSlot().equals(slot)){
                            equippedArmor.remove(arm);
                            switch(slot){
                                case "Head":
                                    headEquiped = false;
                                break;
                                case "Arm":
                                    armEquiped = false;
                                break;
                                case "Legs":
                                    legsEquiped = false;
                                break;
                                case "Chest":
                                    chestEquiped = false;
                                break;
                                case "Feet":
                                    feetEquiped = false;
                                break;
                                case "Ring":
                                    ringEquiped = false;
                                break;
                            }
                             break;
                        }
                    }
                    
    }
    
    public boolean [] getEquipped(){
        boolean [] equipped = new boolean []{headEquiped,
        chestEquiped,
        armEquiped,
        legsEquiped,
        feetEquiped,
        ringEquiped,
        shieldEquiped,
        twoEquiped,
        oneEquiped};
        return equipped;
    }
    public void updateStats(){
        
    }
    
    
    public void addWeapon(Weapon wep, boolean loading){
        wepInventory.add(wep);
        if(!loading){
        gold -= wep.getCost();
        }
    }
    public void addArmor(Armor arm, boolean loading){
        armorInventory.add(arm);
        if(!loading){
        gold -= arm.getCost();
        }
        
    }
    public int getGold(){
        return gold;
    }
    public ArrayList <Weapon> getWepInv(){
        return wepInventory;
    }
    public ArrayList <Armor> getArmInv(){
        return armorInventory;
    }
    public ArrayList <Integer> getBaseStats(){
        return baseStats;
    }
    
    public int[] getStats(){
        int[] statList = new int[]{agi, str, spd, thg, onehand, twohand, shield, lvl, exp, HP, gold};
        return statList;
    }
    public boolean hasMoney(int cost){
        if(cost > gold){
            return false;
        }else{
            return true;
        }
       
    }
    
    public void setStats(String[] posts) {
        for(int i = 1; i < posts.length; i++){
            //System.out.println(posts[i]);
            switch(i){
                case 1:
                    this.agi = Integer.parseInt(posts[1]);
                break;
                case 2:
                    this.str = Integer.parseInt(posts[2]);
                break;
                case 3:
                    this.spd = Integer.parseInt(posts[3]);
                break;
                case 4:
                    this.thg = Integer.parseInt(posts[4]);
                break;
                case 5:
                    this.onehand = Integer.parseInt(posts[5]);
                break;
                case 6:
                    this.twohand = Integer.parseInt(posts[6]);
                break;
                case 7:
                    this.shield = Integer.parseInt(posts[7]);
                break;
                case 8:
                    this.lvl = Integer.parseInt(posts[8]);
                break;
                case 9:
                    this.exp = Integer.parseInt(posts[9]);
                break;
                case 10:
                    this.HP = Integer.parseInt(posts[10]);
                break;
                case 11:
                     this.gold = Integer.parseInt(posts[11]);
                break;
                
                                                    
            }
        }
    }
    
    public String statsToString() {
        int[] statList = new int[]{agi, str, spd, thg, onehand, twohand, shield, lvl, exp, HP, gold};
        String s = "";
        for(int i = 0; i < statList.length; i++){
            if(i == 12){
            String tmp = Integer.toString(statList[i]);
            s += tmp; 
            }else{
            String tmp = Integer.toString(statList[i]) +", ";
            s += tmp; 
            }
            
        }
        return name +", "+ s;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
