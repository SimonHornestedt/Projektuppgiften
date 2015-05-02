
import java.util.ArrayList;


public class Player extends Character{
    private int agi, str, spd, thg, onehand, twohand, hack, stab, crush, lvl, exp, HP, gold;
    ArrayList <Armor> armorInventory = new ArrayList <>();
    ArrayList <Weapon> wepInventory = new ArrayList <>();
    boolean headEquiped,chestEquiped,armEquiped,legsEquiped,feetEquiped,ringEquiped,shieldEquiped,twoEquiped,oneEquiped;
    
    
    
    public Player(String n){
        super(n);
        agi = 10;
        str = 10;
        spd = 10;
        thg = 10;
        onehand = 10;
        twohand = 10;
        hack = 10;
        stab = 10;
        crush = 10;
        lvl = 1;
        exp = 0;
        HP = 20;
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
    }
    @Override
    public Character getCharacters(String n) {
        return this;
    }
    public void addWeapon(Weapon wep){
        wepInventory.add(wep);
        
    }
    @Override
    public int[] getStats(){
        int[] statList = new int[]{agi, str, spd, thg, onehand, twohand, hack, stab, crush, lvl, exp, HP, gold};
        return statList;
    }
    @Override
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
                    this.hack = Integer.parseInt(posts[7]);
                break;
                case 8:
                    this.stab = Integer.parseInt(posts[8]);
                break;
                case 9:
                    this.crush = Integer.parseInt(posts[9]);
                break;
                case 10:
                    this.lvl = Integer.parseInt(posts[10]);
                break;
                case 11:
                    this.exp = Integer.parseInt(posts[11]);
                break;
                case 12:
                    this.HP = Integer.parseInt(posts[12]);
                break;
                case 13:
                    this.gold = Integer.parseInt(posts[13]);
                break;
                                                    
            }
        }
    }
    
    public String statsToString() {
        int[] statList = new int[]{agi, str, spd, thg, onehand, twohand, hack, stab, crush, lvl, exp, HP, gold};
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

    
    
}
