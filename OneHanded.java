
public class OneHanded extends Weapon{
    protected int speed, attack, defense, cost;
    protected String bonus;
    public OneHanded(String n, int attack, int speed, int weight, int cost){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        
    }
    
    @Override
    public String toString() {
        return name; 
    }
    
    public OneHanded createWeapon(int i ) {
        OneHanded wep;
        switch(i){
            case 1:
                wep = new OneHanded("Small Basic Mace", 20, 45, 80, 60);
            break;
            case 2:
                wep = new OneHanded("Basic Dagger", 35, 20, 40, 30);
            break;
            case 3:
                wep = new OneHanded("Shadowmourne", 45, 30, 50, 40);
            break;
            case 4:
                wep = new OneHanded("Angmar", 35, 20, 40, 30);
            break;
            case 5:
                wep = new OneHanded("Fangs of the Father", 35, 20, 40, 30);
            break;
            default:
                wep = new OneHanded("Basic Axe", 35, 20, 40, 30);
            break;
        }
        return wep;
    }
}
