
public class TwoHanded extends Weapon{
    
    protected int speed, attack, defense, cost, weight, lvlReq;
    protected String info, slot, id;
    
    public TwoHanded(String n){
        super(n);
        
        
    }
    
    public TwoHanded(String n, int attack,  int weight, int cost,  String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "2-Handed";
        this.id = id;  
        this.lvlReq = req;
    }  
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    @Override
    public int getSpd(){
        return speed;
    }
    @Override
    public Weapon createWeapon(int i ) {
        Weapon wep;
        switch(i){
            case 1:
                wep = new TwoHanded("Basic Mace", 5,  10, 180, "1", 1);
            break;
            case 2:
                wep = new TwoHanded("Basic Spear", 3, 4, 180,  "2" , 1);
            break;
            case 3:
                wep = new TwoHanded("Frostmourne", 18, 10, 2000, "3",20);
            break;
            case 4:
                wep = new TwoHanded("Sulfuras", 20, 1, 100000, "4", 5);
            break;
            case 5:
                wep = new TwoHanded("Dragon Glavie", 15, 1, 2000, "5", 4);
            break;
            default:
                wep = new TwoHanded("Basic Sword", 4, 5, 180, "0",1);
            break;
        }
        return wep;
    }
    
    @Override
    public String getInfo() {
        info = name +" \nLevel requirement: " + lvlReq +"\nAttack: " + attack + "\nSpeed: " + speed + "\nCost: " +cost;
        return info;
    }
    
    @Override
    public int getCost() {
        return cost;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int[] getStats() {
        int[] stats = new int[]{attack, speed, weight};
        return stats;
    }
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
    
    @Override
    public String getSlot() {
        return slot;
    }

    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDef() {
        return defense;
    }
}
