
public abstract class Weapon {
    protected String name, info;
    
    public Weapon(String n){
        this.name = n;
        
    }
    public abstract String getInfo();
    public abstract int getCost();
    public abstract String toString();
    public abstract String getName();
    public abstract int[] getStats();
    public abstract String getSlot();
    public abstract String toSaveString();
    public abstract Weapon createWeapon(int i);
    public abstract int getAttack();
}