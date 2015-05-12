
import java.util.Random;
import javax.swing.JTextArea;



public class Fight{
    Player hero;
    Monster monster;
    JTextArea txa;
    Random die;
    private String missed, critHit,  firstHit, secondHit, absorbed, winStr;
    
    public Fight(Monster m, Player hero, JTextArea txa){
        this.hero = hero;
        this.monster = m;
        this.txa = txa;
        die = new Random();
    }
    public void battleOn(){
        int i = 1;
        while(monster.isAlive() && hero.isAlive()){
            txa.append("Round: " + i);
            String roundString = "";
            
            txa.append(roundString + "\n \n");
            i++;
        }
    }
    private String firstHitStr(Character a, Character e, int dmg){
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
                        + Integer.toString(dmg)+ " damage";
            break;            
            case 3:
                str = a.getName() + "´s speed gives him the advantage. He "
                        + "finds a chance and attacks. Dealing "
                        + Integer.toString(dmg) + " damage";
            break;
        }
        return str;
    }
    private String critStr(Character a, Character e, int dmg){
        String str = "";
        Random die = new Random();
        int r = die.nextInt(4);
        switch(r){
            default:
                str = "With a swift and precise move " + a.getName() + 
                        " strikes " +e.getName() + " for " 
                        + Integer.toString(dmg) +" damage.";
            break; 
            case 1:
                str = a.getName() + " critically damages " + e.getName() + 
                        " by puncturing a lung with the hard blow. Causing " 
                        + Integer.toString(dmg) + " damage to "  + e.getName() + ".";
            break;
            case 2:
                str = a.getName() +" is lucky when he strikes and he manages "
                        + "to deal "+ Integer.toString(dmg) + " damage to " + e.getName() +".";
            break;            
            case 3:
                str = a.getName() + " lands a devastating blow when he puts "
                        + "all his strenght into the attack." + e.getName() + 
                        " is damaged " + Integer.toString(dmg) + " HP." ;
            break;
        }
        return str;
    }
    private String missStr(Character c){
        String str = null;
        Random die = new Random();
        int r = die.nextInt(4);
        switch(r){
            default:
                str = "A spectator yells loudly and " +c.getName() + 
                     " loses his concentration causing him to miss his attack.";
            break;
            case 1:
                str = c.getName() + " stumbled on his legs "
                        + "and missed his attack.";
            break;
            case 2:
                str = "As " + c.getName() + 
                        " prepares for a attack, a gust of wind blows into "
                        + "the arena and creates a cloud of sand that "
                        + "blocks the vision. " + c.getName()+ 
                        " commits to the attack but misses.";
            break;
            case 3:
                str = c.getName() + " is blinded by anger and he strikes"
                        + " without thought into the air missing a strike "
                        + "that would have been devastating.";
                
            break;    
        }
        return str;
    }
    private void battleOff(){
        
    }
    
}
