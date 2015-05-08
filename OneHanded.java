
public class OneHanded extends Weapon{
    
    protected int speed, attack, defense, cost,weight;
    protected String info, slot, id;
    
    public OneHanded(String n, int attack,  int weight, int cost, String info, String id){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "1-Handed";
        this.id = id;
    }
    
    public OneHanded(String n){
        super(n);           
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
                wep = new OneHanded("Small Basic Mace", 10,  25, 100, "asdad", "1");
            break;
            case 2:
                wep = new OneHanded("Basic Dagger", 10, 3, 100, "asdasd", "2");
            break;
            case 3:
                wep = new OneHanded("Shadowmourne", 35,  5, 300, "asdad","3");
            break;
            case 4:
                wep = new OneHanded("Angmar", 60,  20, 300, "asda", "4");
            break;
            case 5:
                wep = new OneHanded("Fangs of the Father", 35,  1, 300, "asdadad", "5");
            break;
            default:
                wep = new OneHanded("Basic Axe", 20, 15, 100, "asdasd", "0");
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
    @Override
    public int getAttack() {
        return attack;
    }
    
}
