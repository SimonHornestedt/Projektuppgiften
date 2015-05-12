public class Ring extends Armor{

    
    protected int speed, attack, defense, cost,weight, lvlReq;
    protected String slot, id;
    public Ring(String n, int attack, int defense, int speed, int weight, int cost,  String id, int req ){
        super(n);
        this.speed = speed;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.weight = weight;
        this.id = id;
        this.slot = "Ring";
        this.lvlReq = req;
        
    }
    public Ring(String n){
        super(n); 
    }
    
    @Override
    public int getLvlReq() {
        return lvlReq;
    }
    
    @Override
    public String toString() {
        return name + ", " + Integer.toString(weight) + ", " +  slot+ ", " + Integer.toString(attack)+ ", " + Integer.toString(speed) + ", " + Integer.toString(defense);
    }
    
    @Override
    public int getSpd(){
        return speed;
    }
    
    @Override
    public Armor createArmor(int i){
        Armor arm;
        switch(i){
            case 1:
                arm = new Ring("Signet of Speed", 0, 0, 40, 0, 80,  "1", 1);
            break;
            case 2:
                arm = new Ring("Legendary Amulet", 10, 10, 50, 0, 2000, "2", 10);
            break;
            default:
                arm = new Ring("Band of Pain", 20, 0, 0, 0, 80, "0", 5);
            break;
        }
        return arm;
    }

    @Override
    public String getInfo() {
        String info = name +" \nLevel requirement: " + lvlReq +"\nAttack: " + attack + "\nSpeed: " + speed + "\nCost: " +cost;
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
    public String getSlot() {
        return slot;
    }

    @Override
    public String toSaveString() {
        return slot + ", " + id;
    }
    
    @Override
    public int getDefense() {
        return defense;
    }
    
}