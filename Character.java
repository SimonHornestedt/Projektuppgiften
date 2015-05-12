





public abstract class Character{
    protected String name;
    
    public Character(String n){
        this.name = n;
    }
    public abstract void setNewHP(int dmg);
    public abstract int getSpd();
    public abstract boolean critHits();
    public abstract int getAbs();
    public abstract String getName();
    @Override
    public abstract String toString();
    public abstract boolean isAlive();
   
    
}   
