
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Model {
    
    Player hero;
    
    public Model(){
        
    }
    public Player createHero(String heroName){
        hero = new Player(heroName);
        return hero;
    }
    public void saveHero(){
        if(hero!= null){
            
            try{
                FileWriter skrivFil1 = new FileWriter(hero.getName()+".txt"); 
                BufferedWriter writer = new BufferedWriter(skrivFil1);
                PrintWriter skrivFil = new PrintWriter(writer);
                skrivFil.println(hero.statsToString());
                skrivFil.close();
                System.out.println("funkade");
            }catch(IOException e){
                System.out.println("funkade inte");
            }
        }
    }
    public void addWeapon(Weapon wep){
        if(hero.hasMoney(wep.getCost())){  
            hero.addWeapon(wep);
        }else{
            JOptionPane.showMessageDialog(null, "You don't have enough"
                    + " money to buy that!");
        }
        
    }
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
    public void addArmor(Armor arm){
        if(hero.hasMoney(arm.getCost())){  
            hero.addArmor(arm);
        }else{
            JOptionPane.showMessageDialog(null, "You don't have enough money to buy that!");
        }
        
    }
    public Player getHero(){
        return hero;
    }
    public Player loadHero(){
        
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        
        fc.showDialog(null, "Choose Gladiator");
        try{
            
        String filnamn = fc.getSelectedFile().getName(); 
        if(filnamn.contains(".txt")){
            String s;
            try{
                BufferedReader lasFil = new BufferedReader(new FileReader(filnamn));
                s = lasFil.readLine();
                int i = 0;
                while(s != null){    
                String [] posts = s.split(", ");
                    switch(i){
                        case 0:
                            createHero(posts[0]);
                            hero.setStats(posts);
                        break;
                        case 1:
                            //För equipment
                        break;
                        case 2:
                            //För inventory
                        break;
                    }
                s = lasFil.readLine();    
                i++;
                
                }
            lasFil.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "You didn't pick a valid file");
        }
        }
        }catch(NullPointerException e){
               JOptionPane.showMessageDialog(null, "You didn't pick a valid file");
        }
        return hero;
     }
    
}
