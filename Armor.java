

    public abstract class Armor {
    protected String name, info;
    
    public Armor(String n, String info){
        this.name = n;
        this.info = info;
    }
    public abstract String getInfo();
    public abstract int getCost();
    public abstract String toString();
    public abstract String getName();
}

