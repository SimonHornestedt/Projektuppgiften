public class Ring extends Armor{

    
    protected int speed, attack, defense, cost,weight;
    protected String slot, id;
    public Ring(String n, int attack, int defense, int speed, int weight, int cost,  String id ){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.id = id;
        this.slot = "Ring";
    }
    public Ring(String n){
        super(n);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Armor createArmor(int i){
        Armor arm;
        switch(i){
            case 1:
                arm = new Ring("Signet of Speed", 0, 0, 75, 5, 80,  "1");
            break;
            case 2:
                arm = new Ring("Legendary Amulet", 80, 80, 80, 10, 2000, "2");
            break;
            default:
                arm = new Ring("Band of Pain", 60, 0, 0, 10, 80, "0");
            break;
        }
        return arm;
    }

    @Override
    public String getInfo() {
        return name;
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
    public String getSlot() {
        return slot;
    }

    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    
}