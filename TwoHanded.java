
public class TwoHanded extends Weapon{
    protected int speed, attack, defense, cost, weight;
    protected String info;
    public TwoHanded(String n,String info){
        super(n, info);
        
        
    }
    public TwoHanded(String n, int attack, int speed, int weight, int cost, String info){
        super(n, info);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + "2-Handed"+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    
    public TwoHanded createWeapon(int i ) {
        TwoHanded wep;
        switch(i){
            case 1:
                wep = new TwoHanded("Basic Mace", 20, 45, 80, 60, "asdada");
            break;
            case 2:
                wep = new TwoHanded("Basic Spear", 35, 20, 40, 30, "asdada");
            break;
            case 3:
                wep = new TwoHanded("Frostmourne", 45, 30, 50, 40, "asdada");
            break;
            case 4:
                wep = new TwoHanded("Sulfuras", 35, 20, 40, 30, "asdada");
            break;
            case 5:
                wep = new TwoHanded("Dragon Glavie", 35, 20, 40, 30, "asdada");
            break;
            default:
                wep = new TwoHanded("Basic Sword", 35, 20, 40, 30, "asdada");
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
}
