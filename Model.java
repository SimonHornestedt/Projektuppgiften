
import java.io.*;
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
        hero.addWeapon(wep);
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
