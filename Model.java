
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
     * Version 1.0.1.2
     * @author Simon Hornestedt och Mattias Nordberg
     */

public class Model {
    
    /**
     * Medlemsvariabler
     */
    Player hero;
    boolean loading;
    
    /**
     * Konstruktor  för klassen Model
     */
    public Model(){
        loading = false;
    }
    
    /*
        Anledningen till att denna metod inte ligger i konstruktorn
        är att vi bara ville skapa en hero då vi laddade in en gubbe.
    */
    /**
     * Skapar en Spelare 
     * @param heroName spelarens namn
     * @return Den skapade spelaren
     */
    public Player createHero(String heroName){
        hero = new Player(heroName);
        return hero;
    }
    
    /**
     * Sparar hjälten i en TXT fil.
     */
    public void saveHero(){
        if(hero!= null){
            try{
                FileWriter skrivFil1 = new FileWriter(hero.getName()+".txt"); 
                BufferedWriter writer = new BufferedWriter(skrivFil1);
                PrintWriter skrivFil = new PrintWriter(writer);
                skrivFil.println(hero.statsToString());
                skrivFil.println("INVENTORY");
                    for(Weapon wep : hero.getWepInv()){
                        skrivFil.println(wep.toSaveString());
                    }
                    for(Armor arm : hero.getArmInv()){
                        skrivFil.println(arm.toSaveString());
                    }
                skrivFil.println("GEAR");
                    for(Weapon wep : hero.getEquippedWep()){
                        skrivFil.println(wep.toSaveString());
                    }
                    for(Armor arm : hero.getEquippedArmor()){
                        skrivFil.println(arm.toSaveString());
                    }
                skrivFil.close();
                System.out.println("funkade");
            }catch(IOException e){
                System.out.println("funkade inte");
            }
        }
    }
    
    /**
     * Lägger till ett vapen på en vald plats.
     * @param slot den valda platsen
     * @param name namnet på vapnet
     */
    public void equipWeapon(String slot, String name){
        
        if("1-Handed".equals(slot) || "2-Handed".equals(slot) 
                || "Shield".equals(slot)){
            ArrayList <Weapon> wepInv = hero.getWepInv();
            for(Weapon wep: wepInv){
                if(wep.getName().equals(name)){
                    hero.equipWeapon(wep, slot);
                    break;
                }
            }
        }else if("Chest".equals(slot) ||"Head".equals(slot) 
                ||"Arm".equals(slot) ||"Legs".equals(slot) 
                ||"Feet".equals(slot) || "Ring".equals(slot)){
            ArrayList <Armor> armInv = hero.getArmInv();
            for(Armor arm: armInv){
                if(arm.getName().equals(name)){
                    hero.equipArmor(arm, slot);
                    break;
                }
            }
        }
    }
    
    /**
     * tar av ett vapen från spelaren från angiven plats
     * @param slot angiven plats
     */
    public void unequipWeapon(String slot){
        hero.unequipWeapon(slot);
    }
    
    /**
     * tar bort rustning från angiven plats
     * @param slot angiven plats
     */
    public void unequipArmor(String slot){
        hero.unequipArmor(slot);
    }
    
    /**
     * Lägger till ett vapen
     * @param wep vapnet som skall läggas till
     */
    public void addWeapon(Weapon wep){
        if(hero.hasMoney(wep.getCost())){  
            hero.addWeapon(wep,loading);
        }else{
            JOptionPane.showMessageDialog(null, "You don't have enough"
                    + " money to buy that!");
        }
        
    }
    
    /**
     * Hämtar info för vapen eller rustning
     * @param slot angiven plats
     * @param name namnet på det som ska hämtas 
     * @return String med full information om vapnet eller rustningen
     */
    public String getInfo(String slot, String name){
        String str = null;
        if("1-Handed".equals(slot) || "2-Handed".equals(slot) 
                || "Shield".equals(slot)){
            ArrayList <Weapon> wepInv = hero.getWepInv();
            for(Weapon wep: wepInv){
                if(wep.getName().equals(name)){
                    str = wep.getInfo();
                }
            }
        }else if("Chest".equals(slot) ||"Head".equals(slot) 
                ||"Arm".equals(slot) ||"Legs".equals(slot) 
                ||"Feet".equals(slot) || "Ring".equals(slot)){
            ArrayList <Armor> armInv = hero.getArmInv();
            for(Armor arm: armInv){
                if(arm.getName().equals(name)){
                    str = arm.getInfo();
                }
            }
        }
        
        return str;
    }
    
    /**
     * Lägger till rustning
     * @param arm rustningen som skall läggas till
     */
    public void addArmor(Armor arm){
        if(hero.hasMoney(arm.getCost())){  
            hero.addArmor(arm, loading);
        }else{
            JOptionPane.showMessageDialog(null, "You don't have enough money to buy that!");
        }
        
    }
    
    /**
     * Hämtar hjälten 
     * @return hjälten
     */
    public Player getHero(){
        return hero;
    }
    
    /**
     * laddar in en hjälte
     * @return den inladdade spelaren
     */
    public Player loadHero(){
        loading = true;
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.showDialog(null, "Choose Gladiator");
       try{    
        String filnamn = fc.getSelectedFile().getName(); 
        System.out.println(filnamn);
        if(filnamn.contains(".txt")){
            String s;
            try{
                BufferedReader lasFil = new BufferedReader(new FileReader(filnamn));
                s = lasFil.readLine();
                String [] posts = s.split(", ");
                createHero(posts[0]);
                hero.setStats(posts);
                while(s != null){    
                            if("INVENTORY".equals(s)){
                                s = lasFil.readLine();
                                while(!"GEAR".equals(s)){
                                    posts = s.split(", ");
                                    if("Cloth".equals(posts[0]) || "Leather".equals(posts[0]) || "Metal".equals(posts[0])|| "Ring".equals(posts[0])){
                                        Armor arm;
                                        switch (posts[0]){
                                            case "Cloth":
                                                arm = new Cloth("dummy");
                                                hero.addArmor(arm.createArmor(Integer.parseInt(posts[1])),loading);
                                            break;
                                            case "Leather":
                                                arm = new Leather("dummy");
                                                hero.addArmor(arm.createArmor(Integer.parseInt(posts[1])),loading);
                                            break;
                                            case "Metal":
                                                arm = new Metal("dummy");
                                                hero.addArmor(arm.createArmor(Integer.parseInt(posts[1])),loading);
                                            break;
                                            case "Ring":
                                                arm = new Ring("dummy");
                                                hero.addArmor(arm.createArmor(Integer.parseInt(posts[1])), loading);
                                            break;
                                        }
                                    }else if( "1-Handed".equals(posts[0]) || "2-Handed".equals(posts[0]) || "Shield".equals(posts[0]) ){
                                         Weapon wep;
                                        switch (posts[0]){
                                            case "1-Handed":
                                                wep = new OneHanded("dummy");
                                                hero.addWeapon(wep.createWeapon(Integer.parseInt(posts[1])),loading);
                                            break;
                                            case "2-Handed":
                                                wep = new TwoHanded("dummy");
                                                hero.addWeapon(wep.createWeapon(Integer.parseInt(posts[1])),loading);
                                            break;
                                            case "Shield":
                                                wep = new Shield("dummy");
                                                hero.addWeapon(wep.createWeapon(Integer.parseInt(posts[1])),loading);
                                            break;
                                            
                                        }       
                                    }
                                    s = lasFil.readLine();
                                }
                            }
                            if("GEAR".equals(s)){
                                s = lasFil.readLine();
                                while(s!= null){
                                    posts = s.split(", ");
                                    if("Cloth".equals(posts[0]) || "Leather".equals(posts[0]) || "Metal".equals(posts[0])|| "Ring".equals(posts[0])){
                                        Armor arm;
                                        switch (posts[0]){
                                            case "Cloth":
                                                arm = new Cloth("dummy");
                                                hero.equipLoadedGear(arm.createArmor(Integer.parseInt(posts[1])));
                                            break;
                                            case "Leather":
                                                arm = new Leather("dummy");
                                                hero.equipLoadedGear(arm.createArmor(Integer.parseInt(posts[1])));
                                            break;
                                            case "Metal":
                                                arm = new Metal("dummy");
                                                hero.equipLoadedGear(arm.createArmor(Integer.parseInt(posts[1])));
                                            break;
                                            case "Ring":
                                                arm = new Ring("dummy");
                                                hero.equipLoadedGear(arm.createArmor(Integer.parseInt(posts[1])));
                                            break;
                                        }
                                    }else if( "1-Handed".equals(posts[0]) || "2-Handed".equals(posts[0]) || "Shield".equals(posts[0]) ){
                                        Weapon wep;
                                        switch (posts[0]){
                                            case "1-Handed":
                                                wep = new OneHanded("dummy");
                                                hero.equipLoadedWeapons(wep.createWeapon(Integer.parseInt(posts[1])));
                                            break;
                                            case "2-Handed":
                                                wep = new TwoHanded("dummy");
                                                hero.equipLoadedWeapons(wep.createWeapon(Integer.parseInt(posts[1])));
                                            break;
                                            case "Shield":
                                                wep = new Shield("dummy");
                                                hero.equipLoadedWeapons(wep.createWeapon(Integer.parseInt(posts[1])));
                                            break;      
                                        }       
                                    }
                                    s = lasFil.readLine();
                                }
                            }
                s = lasFil.readLine();    
                }
            lasFil.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, " You didn't pick a valid file 1");
        }
        }
       }catch(NullPointerException e){
           JOptionPane.showMessageDialog(null, "You didn't pick a valid file 2");        }
        loading = false;
        return hero;
     }
    
}
