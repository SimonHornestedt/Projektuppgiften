

    public abstract class Armor {
    protected String name;
    
    public Armor(String n){
        this.name = n;
        
    }
    public abstract String getInfo();
    public abstract int getCost();
    public abstract String toString();
    public abstract String getName();
    public abstract String getSlot();
    public abstract String toSaveString();
    public abstract Armor createArmor(int i);
    
}

