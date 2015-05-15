/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JTextArea;



public class Fight{
    /**
     * Medlemsvariabler
     */
    Player hero;
    Monster monster;
    JTextArea txa;
    JButton btn;
    Random die;
    boolean herolvledUP;
    private String winStr, roundString;
    
    /**
     * Konstruktor för klassen Fight
     * @param m monstret
     * @param hero spelaren
     * @param txa textArean som ska hantera fighten
     * @param btn enterArena knappen
     */
    public Fight(Monster m, Player hero, JTextArea txa, JButton btn){
        this.hero = hero;
        this.monster = m;
        this.txa = txa;
        this.herolvledUP = false;
        this.btn = btn;
        die = new Random();
        txa.setText("");
    }
    
    /**
     * författar en absorb sträng
     * @param e Den attackerade karaktären
     * @return författad absorbsträng
     */
    private String absStr(Character e){
        String str = "";
        str = e.getName() + "'s armor absorbs " + Integer.toString(e.getAbs()) +" damage. ";
        return str;
    }
    
    /**
     * Kör fighten.
     */
    public void battleOn(){
        int i = 1;
        boolean secondHit = true;
        while(monster.isAlive() && hero.isAlive()){
            txa.append("Round: " + i +" \n \n");
            roundString = "";
            int heroSpdBonus = die.nextInt(25) +1;
            int monstSpdBonus = die.nextInt(25) +1;
            if(heroSpdBonus + hero.getSpd() > monstSpdBonus + monster.getSpd()){
                
                heroStrike();
                secondHit = false;
            }else if(heroSpdBonus + hero.getSpd() <= monstSpdBonus + monster.getSpd()){
                
                monsterStrike();
            }
            if(monster.isAlive() && hero.isAlive()){
                if(secondHit){
                    
                    heroStrike();
                }else{
                    
                    monsterStrike();
                }
            }
            txa.append(roundString + "\n \n");
            i++;
        }
        battleOff();
    }
    
    /**
     * Hjälten slår sitt slag.
     */
    private void heroStrike(){
        int cc = die.nextInt(100)+1;
        int mc = die.nextInt(100)+1;
        if(mc < hero.getMiss()){
            roundString += missStr(hero);
            System.out.println("hero miss");
        }else{
            if(cc > hero.getCrit()){
                int dmg = hero.getDmg() *2;
                roundString += critStr(hero, monster, dmg);
                dmg -= monster.getAbs();
                roundString += absStr(monster);
                monster.setNewHP(dmg);
                System.out.println("hero crit");
            }else{
                int dmg = hero.getDmg();
                roundString += hitStr(hero, monster, dmg);
                dmg -= monster.getAbs();
                roundString += absStr(monster);
                monster.setNewHP(dmg);
                System.out.println("hero hit");
            }
        }
        
    }
    
    /**
     * Monstret slår sitt slag.
     */
    private void monsterStrike(){
        int cc = die.nextInt(100)+1;
        int mc = die.nextInt(100)+1;
        if(mc < monster.getMiss()){
            roundString += missStr(monster);
            System.out.println("monster miss");
        }else{
            if(cc > monster.getCrit()){
                int dmg = monster.getDmg() *2;
                roundString += critStr(monster, hero, dmg);
                dmg -= hero.getAbs();
                roundString += absStr( hero);
                hero.setNewHP(dmg);
                System.out.println("Monster crit");
            }else{
                int dmg = monster.getDmg();
                roundString += hitStr(monster, hero, dmg);
                dmg -= hero.getAbs();
                roundString += absStr(hero);
                hero.setNewHP(dmg);
                System.out.println("Monster hit");
            }
        }
    }
    
    /**
     * Författar en hitString
     * @param a attackerande Karaktär
     * @param e attackerad karaktär
     * @param dmg skadan som görs
     * @return författad sträng för hit 
     */
    private String hitStr(Character a, Character e, int dmg){
        String str = "";
        Random die = new Random();
        int r = die.nextInt(4);
        switch(r){
            default:
                str =  a.getName() + " takes the initiative and strikes before " 
                        +e.getName() + " manages to react. " + a.getName()+ " deals "
                        + Integer.toString(dmg) +" damage. ";
            break; 
            case 1:
                str = a.getName() + " tricks " + e.getName() + " by kicking"
                        + " sand into his face and gets the upper hand. "+ 
                        a.getName()+ " deals " + Integer.toString(dmg) + " damage.";
            break;
            case 2:
                str = e.getName()+ " stumbles and " + a.getName()+ "takes the "
                        + "opportunity and strikes for " 
                        + Integer.toString(dmg)+ " damage. ";
            break;            
            case 3:
                str = a.getName() + "´s speed gives him the advantage. He "
                        + "finds a chance and attacks. Dealing "
                        + Integer.toString(dmg) + " damage. ";
            break;
        }
        return str;
    }
    
    /**
     * Författar en crit String
     * @param a attackerande Karaktär
     * @param e attackerad karaktär
     * @param dmg skadan som görs
     * @return författad sträng för crit 
     */
    private String critStr(Character a, Character e, int dmg){
        String str = "";
        Random die = new Random();
        int r = die.nextInt(4);
        switch(r){
            default:
                str = "With a swift and precise move " + a.getName() + 
                        " strikes " +e.getName() + " for " 
                        + Integer.toString(dmg) +" damage. ";
            break; 
            case 1:
                str = a.getName() + " critically damages " + e.getName() + 
                        " by puncturing a lung with the hard blow. Causing " 
                        + Integer.toString(dmg) + " damage to "  + e.getName() + ". ";
            break;
            case 2:
                str = a.getName() +" is lucky when he strikes and he manages "
                        + "to deal "+ Integer.toString(dmg) + " damage to " + e.getName() +". ";
            break;            
            case 3:
                str = a.getName() + " lands a devastating blow when he puts "
                        + "all his strenght into the attack." + e.getName() + 
                        " is damaged " + Integer.toString(dmg) + " HP. " ;
            break;
        }
        return str;
    }
    
    /**
     * Författar en miss sträng
     * @param c karaktären som missar
     * @return författad miss sträng
     */
    private String missStr(Character c){
        String str = null;
        Random die = new Random();
        int r = die.nextInt(4);
        switch(r){
            default:
                str = "A spectator yells loudly and " +c.getName() + 
                     " loses his concentration causing him to miss his attack. ";
            break;
            case 1:
                str = c.getName() + " stumbled on his legs "
                        + "and missed his attack. ";
            break;
            case 2:
                str = "As " + c.getName() + 
                        " prepares for a attack, a gust of wind blows into "
                        + "the arena and creates a cloud of sand that "
                        + "blocks the vision. " + c.getName()+ 
                        " commits to the attack but misses. ";
            break;
            case 3:
                str = c.getName() + " is blinded by anger and he strikes"
                        + " without thought into the air missing a strike "
                        + "that would have been devastating. ";
                
            break;    
        }
        return str;
    }
    
    /**
     * Körs när någon vunnit fighten
     */
    private void battleOff(){
        
        
        if(hero.isAlive()){
            boolean b = hero.giveRewards(monster.getExpReward(), monster.getGoldReward());
            if(b){
                herolvledUP = true;
                winStr = hero.getName() + " has been awarded with the victory and has aquired "+ Integer.toString(monster.getExpReward()) + " exp and " + Integer.toString(monster.getGoldReward()) + " gold. \n \n" ;
                txa.append(winStr);
            }else{
                winStr = hero.getName() + " has been awarded with the victory and has aquired "+ Integer.toString(monster.getExpReward()) + " exp and " + Integer.toString(monster.getGoldReward()) + " gold. \n \n" ;
                txa.append(winStr);
            }
            heroWon();
            hero.setBaseHP();
        }else if(monster.isAlive()){
            winStr = monster.getName() + " has been awarded with the victory and" + hero.getName() + " has been sent to the infimary for 1 minute\n \n";
            txa.append(winStr);  
            heroDead();
            
        }
        
    }
    
    /**
     * "söver" knappen om heron har dött
     */
    private void heroDead(){
         Runnable r = new Runnable() {
            @Override
            public void run(){
                
                btn.setEnabled(false);
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fight.class.getName()).log(Level.SEVERE, null, ex);
                }
                btn.setEnabled(true);
                hero.setBaseHP();
                
            }
        };
        Thread thr = new Thread(r);
        thr.start();
    }
    
    /**
     * Söver knappen en kortare tid om spelaren vunnit
     */
    private void heroWon(){
         Runnable r = new Runnable() {
            @Override
            public void run(){
                
                btn.setEnabled(false);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fight.class.getName()).log(Level.SEVERE, null, ex);
                }
                btn.setEnabled(true);
                hero.setBaseHP();
                
            }
        };
        Thread thr = new Thread(r);
        thr.start();
    }
    
    /**
     * kontrollerar om spelaren blev en nivå högre efter matchen
     * @return boolean, true om man levlat up false om man inte gjort det.
     */
    public boolean getLvledUP(){
        return herolvledUP;
    }
    
}
