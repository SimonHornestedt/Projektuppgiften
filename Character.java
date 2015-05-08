





public abstract class Character implements Comparable {
    protected String name;
    
    public Character(String n){
        this.name = n;
    }
    
   
    
    public abstract String getName();
    @Override
    public abstract String toString();
    public abstract boolean isAlive();
}   
