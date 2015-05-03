
public class OneHanded extends Weapon{
    protected int speed, attack, defense, cost,weight;
    protected String info;
    public OneHanded(String n, int attack, int speed, int weight, int cost, String info){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
    }
    public OneHanded(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " + "1-Handed"+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public OneHanded createWeapon(int i ) {
        OneHanded wep;
        switch(i){
            case 1:
                
                wep = new OneHanded("Small Basic Mace", 10, -5, 10, 50, 
                        "This mace has a heavy head wich makes it"
                                + " a slow but hard hitter. Requirements:" +
                                "\n" + "Strength: 50" + "\n" + "Crush: 25" );
            break;
            case 2:
                wep = new OneHanded("Basic Dagger", 35, 20, 40, 50, "This dagger"
                        + " was forged by elves, which makes"
                        + " it light, fast and sharp. Requirements:"
                        + "\n" + "Agility: 50" + "\n" + "Stab: 25");
            break;
            case 3:
                wep = new OneHanded("Shadowmourne", 45, 30, 50, 40, "asdad");
            break;
            case 4:
                wep = new OneHanded("Angmar", 35, 20, 40, 30, "asda");
            break;
            case 5:
                wep = new OneHanded("Fangs of the Father", 35, 20, 40, 30, "asdadad");
            break;
            default:
                wep = new OneHanded("Basic Axe", 35, 20, 40, 30, "asdasd");
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
