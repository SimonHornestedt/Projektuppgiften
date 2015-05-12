
public class OneHanded extends Weapon{
    
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String info, slot, id;
    
    public OneHanded(String n, int attack,  int weight, int cost, String id, int req){
        super(n);
        this.speed = (int)(100/weight);
        this.attack = attack;
        this.defense = 0;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = "1-Handed";
        this.id = id;
        this.lvlReq = req;
    }
    
    public OneHanded(String n){
        super(n);           
    }
    @Override
    public int getSpd(){
        return speed;
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
                wep = new OneHanded("Small Basic Mace", 10,  5, 100, "1" , 1);
            break;
            case 2:
                wep = new OneHanded("Basic Dagger", 10, 3, 100, "2", 1);
            break;
            case 3:
                wep = new OneHanded("Shadowmourne", 35,  8, 300 ,"3", 8);
            break;
            case 4:
                wep = new OneHanded("Angmar", 60,  15, 300, "4", 10);
            break;
            case 5:
                wep = new OneHanded("Fangs of the Father", 35,  1, 300, "5", 6);
            break;
            default:
                wep = new OneHanded("Basic Axe", 20, 4, 100, "0", 1);
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
    public int getDef() {
        return defense;
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
    public int getLvlReq() {
        return lvlReq;
    }
    
}
