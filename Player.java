
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
public class Player extends Character{
    /**
     * Medlemsvariabler
     */
    private int agi, str, spd, thg, onehand, 
            twohand,shield, lvl, exp, HP, 
            gold, dmg, defense, attack, wepSkill,
            crit, abs ,miss, baseHP, baseSpd;
   
    private ArrayList <Armor> armorInventory;
    private ArrayList <Weapon> wepInventory;
    boolean headEquiped,chestEquiped,armEquiped,legsEquiped,
            feetEquiped,ringEquiped,shieldEquiped,twoEquiped,oneEquiped;
    
    private ArrayList <Weapon> equippedWep;
    private ArrayList <Armor> equippedArmor;
    
    /**
     * Konstruktor till klassen player
     * @param n String med namnet på karaktären
     */
    public Player(String n){
        super(n);
        agi = 10;
        str = 10;
        baseSpd = 10;
        thg = 10;
        onehand = 10;
        twohand = 10;
        shield = 10;
        lvl = 1;
        exp = 0;
        HP = (int) (thg*1.2) ;
        baseHP = (int) (thg*1.2);
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
        defense = this.calcDef();
        attack = this.calcAtk();
        abs = (int) (defense*0.2);
        wepSkill = this.calcWepSkill();
        miss = 100/wepSkill;
        dmg = (int)((str*0.1) + (agi*0.1) + (attack*0.1));
        crit = (int)(100 -((agi + spd)*0.1));
        spd = calcSpd();
        
    }
    
    /**
     * Hämtar spelarens level
     * @return int med leveln
     */
    public int getLvl() {
        return lvl;
    }
    
    /**
     * Delar ut pengar och exp till spelaren
     * @param exp int mängd exp
     * @param gold itn mängd guld
     * @return skickar skickar tillbaka sant om 
     * spelare anvancerat en level av den exp den fått.
     */
    public boolean giveRewards(int exp, int gold){
        this.gold += gold;
        int reqExp = 100*lvl;
        this.exp += exp;
        if(this.exp >= reqExp){
            lvl++;
            this.exp = 0;
            return true;
        }else{
            return false;
        }    
    }
    
    /**
     * Skickar spelarens skadepoäng
     * @return int med skadan
     */
    public int getDmg() {
        return dmg;
    }
    
    /**
     * Hämtar spelarens chans att skada dubbelt
     * @return int chans att skada dubbelt 
     */
    public int getCrit() {
        return crit;
    }
    
    /** 
     * Hämtar spelarens absorb
     * @return int absorb
     */
    public int getAbs() {
        return abs;
    }
    
    /**
     * Räknar ut spelarens snabbhet
     * @return int med spelarens hastighet
     */
    public int calcSpd(){
        this.spd = baseSpd;
        int n = 0;
        for(Weapon wep : equippedWep){
            this.spd += wep.getSpd();
            n++;
        }
        for(Armor arm : equippedArmor){
            this.spd += arm.getSpd();
            n++;
        }
        if(n != 0){
            return spd/n;
        }else{
            return spd;
        }
        
    }
    
    /**
     * Hämtar miss chansen
     * @return int misschans
     */
    public int getMiss() {
        return miss;
    }
    
    /**
     * Beräknar spelarens försvar
     * @return int spelarens försvar
     */
    private int calcDef(){
        int def = 0;
        if(!equippedArmor.isEmpty()){
            for(Armor arm : equippedArmor){
                int tmp = arm.getDefense();
                def += tmp;
            }
        }
        if(shieldEquiped){
            for(Weapon wep : equippedWep){
                if("Shield".equals(wep.getSlot())){
                int tmp = wep.getDef();
                def += tmp;
                }
            }
        }
        return def;
    }
    
    /**
     * Beräknar spelarens anfall
     * @return int spelarens anfall
     */
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
    
    /**
     * Beräknar spelarens vapenfärdighet med det valda vapnet
     * @return int spelarens vapenfärdighet
     */
    private int calcWepSkill(){
        int wS = 10;
        if(oneEquiped){
            wS = onehand;
        }else if(twoEquiped){
            wS = twohand;
        }
        return wS;
    }
     
    
    /**
     * Hämtar vapen som hjälten håller i 
     * @return ArrayList <Weapon> Hjätens vapen
     */
    public ArrayList<Weapon> getEquippedWep() {
        return equippedWep;
    }
    
    /**
     * Hämtar utrustning som hjälten håller i 
     * @return ArrayList <Armor> Hjätens utrustning
     */
    public ArrayList<Armor> getEquippedArmor() {
        return equippedArmor;
    }
    
    /**
     * ger spelaren de vapen som laddats in
     * @param w Det vapen som har laddats in
     */
    public void equipLoadedWeapons(Weapon w){
        String slot = w.getSlot();
        this.equipWeapon(w, slot);
    }
    
    /**
     * ger spelaren den utrustning som laddats in
     * @param a Den utrustning som har laddats in
     */
    public void equipLoadedGear(Armor a){
        String slot = a.getSlot();
        this.equipArmor(a, slot);
    }
    
    /**
     * ger spelaren ett vapen
     * @param w Vapnet som ska läggas in
     * @param slot platsen den ska läggas till på
     */
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
    /**
     * Klär på spelaren vald utrustning
     * @param a Armor utrustning som ska sättas på 
     * @param slot platsen den ska läggas till på.
     */
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
    /**
     * Tar av ett vapen från given plats
     * @param slot String med given plats
     */
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
        updateStats();
                    
    }
    /**
     * Tar av utrustning från given plats
     * @param slot sträng med given plats
     */
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
        updateStats();
                    
    }
    /**
     * Hämtar en lista med booleans för vilka platser som är "påklädda"
     * @return boolean [] värden för varje plats
     */
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
    /**
     *updaterar stats för hjälten. 
     */
    public void updateStats(){
        defense = this.calcDef();
        attack = this.calcAtk();
        abs = (int) (defense*0.2);
        wepSkill = this.calcWepSkill();
        miss = 100/wepSkill;
        dmg = (int)((str*0.1) + (agi*0.1) + attack*0.1);
        crit = (int)(100- ((agi + spd) *0.1));
        baseHP = (int) (thg*1.2);
        spd = calcSpd();
    }
    /**
     * Hämtar snabbheten 
     * @return int snabbheten
     */
    @Override
    public int getSpd(){
        return spd;
    }
    /**
     * sätter HP till max HP.
     */
    public void setBaseHP(){
        HP = baseHP;
    }
    /**
     * lägger till ett vapen i "ryggsäcken".
     * @param wep vapnet som ska läggas till
     * @param loading boolean för om programmet laddar in en gubbe
     */
    public void addWeapon(Weapon wep, boolean loading){
        wepInventory.add(wep);
        if(!loading){
        gold -= wep.getCost();
        }
    }
    /**
     * lägger till en utrusting i "ryggsäcken".
     * @param arm  utrustning som ska läggas till
     * @param loading boolean för om programmet laddar in något
     */
    public void addArmor(Armor arm, boolean loading){
        armorInventory.add(arm);
        if(!loading){
        gold -= arm.getCost();
        }
        
    }
    /**
     * hämtar  spelarens pengar
     * @return int med pengar
     */
    public int getGold(){
        return gold;
    }
    /**
     * Hämtar vapen-"inventoryt" 
     * @return ArrayList med vapen
     */
    public ArrayList <Weapon> getWepInv(){
        return wepInventory;
    }
    /**
     * Hämtar rustnings-"inventoryt" 
     * @return ArrayList med rustning
     */
    public ArrayList <Armor> getArmInv(){
        return armorInventory;
    }
    
    
    /**
     * Hämtar hjältens "stats"
     * @return int [] med stats
     */
    public int[] getStats(){
        int[] statList = new int[]{agi, str, spd, thg, onehand, twohand, shield, lvl, exp, baseHP, gold};
        return statList;
    }
    public boolean hasMoney(int cost){
        if(cost > gold){
            return false;
        }else{
            return true;
        }
       
    }
    /**
     * Sätter stats för hjälten
     * @param posts String [] med nya värden
     */
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
    /**
     * Skriver ut stats som en sträng
     * @return Sträng med alla stats
     */
    
    public String statsToString() {
        int[] statList = new int[]{agi, str, baseSpd, thg, onehand, twohand, shield, lvl, exp, baseHP, gold};
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
    /**
     * Hämtar namnet
     * @return String med namnet
     */
    @Override
    public String getName() {
        return name;
    }

    
    /**
     * Kontrollerar om spelaren lever
     * @return true om den lever false om den är död
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
     * sätter nytt hp baserat på inkommande skada
     * @param dmg inkommande skada
     */
    @Override
    public void setNewHP(int dmg) {
        if(dmg > 0){
           HP -=dmg;
        }        
    }
    /**
     * Sätter nya stats då karaktären levlar up
     * @param stats de valda statsen från  hero fönstret
     */
    public void levelUP(int [] stats){
        for(int i = 0; i < stats.length; i++){
            switch(i){
                case 0:
                    agi += stats[i];
                break;
                case 1:
                    str += stats[i];
                break;
                case 2:
                    baseSpd += stats[i];
                break;
                case 3:
                    thg += stats[i];
                break;    
                case 4:
                    onehand += stats[i];
                break;
                case 5:
                    twohand += stats[i];
                break;
                case 6:
                    shield += stats[i];
                break;
            }
            
        }
        updateStats();
    }

    
    
    
}
