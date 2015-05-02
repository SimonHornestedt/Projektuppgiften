
import java.util.ArrayList;




public abstract class Character {
    protected String name;
    
    public Character(String n){
        this.name = n;
    }
    public abstract void setStats(String[] posts);
    public abstract int[] getStats();
    public abstract Character getCharacters(String n);
    public abstract String getName();
    @Override
    public abstract String toString();
}   
