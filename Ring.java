public class Ring extends Armor{

    
    protected int speed, attack, defense, cost,weight;
    protected String info, slot;
    public Ring(String n, int attack, int defense, int speed, int weight, int cost, String info, String slot){
        super(n,info);
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.info = info;
        this.slot = slot;
    }
    public Ring(String n,String info){
        super(n, info);
        
        
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    public Ring createArmor(int i){
        Ring arm;
        switch(i){
            case 1:
                arm = new Ring("Signet of Speed", 20, 23, 45, 80, 60, "asdsdas", "Ring");
            break;
            case 2:
                arm = new Ring("Legendary Amulet", 20, 23, 45, 80, 100, "asdsdas", "Ring");
            break;
            default:
                arm = new Ring("Band of Pain", 23, 35, 20, 40, 30, "asdasd", "Ring");
            break;
        }
        return arm;
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