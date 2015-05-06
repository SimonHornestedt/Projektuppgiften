
public class TwoHanded extends Weapon{
    
    protected int speed, attack, defense, cost, weight;
    protected String info, slot, id;
    
    public TwoHanded(String n){
        super(n);
        
        
    }
    
    public TwoHanded(String n, int attack,  int weight, int cost, String info, String id){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "2-Handed";
        this.id = id;      
    }  
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    @Override
    public Weapon createWeapon(int i ) {
        Weapon wep;
        switch(i){
            case 1:
                wep = new TwoHanded("Basic Mace", 35,  120, 180, "asdada", "1");
            break;
            case 2:
                wep = new TwoHanded("Basic Spear", 20, 40, 180, "asdada", "2");
            break;
            case 3:
                wep = new TwoHanded("Frostmourne", 50, 70, 400, "asdada", "3");
            break;
            case 4:
                wep = new TwoHanded("Sulfuras", 90, 250, 420, "asdada", "4");
            break;
            case 5:
                wep = new TwoHanded("Dragon Glavie", 45, 60, 400, "asdada", "5");
            break;
            default:
                wep = new TwoHanded("Basic Sword", 30, 55, 180, "asdada", "0");
            break;
        }
        return wep;
    }
    
    @Override
    public String getInfo() {
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
    public String getSlot() {
        return slot;
    }

    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
}
