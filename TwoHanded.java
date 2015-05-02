
public class TwoHanded extends Weapon{
    protected int speed, attack, defense, cost;
    protected String bonus;
    public TwoHanded(String n, int attack, int speed, int weight, int cost){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        
    }
    
    @Override
    public String toString() {
        return name; 
    }
    
    public TwoHanded createWeapon(int i ) {
        TwoHanded wep;
        switch(i){
            case 1:
                wep = new TwoHanded("Basic Mace", 20, 45, 80, 60);
            break;
            case 2:
                wep = new TwoHanded("Basic Spear", 35, 20, 40, 30);
            break;
            case 3:
                wep = new TwoHanded("Frostmourne", 45, 30, 50, 40);
            break;
            case 4:
                wep = new TwoHanded("Sulfuras", 35, 20, 40, 30);
            break;
            case 5:
                wep = new TwoHanded("Dragon Glavie", 35, 20, 40, 30);
            break;
            default:
                wep = new TwoHanded("Basic Sword", 35, 20, 40, 30);
            break;
        }
        return wep;
    }
}
