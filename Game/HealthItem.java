
public class HealthItem extends Thing{
    
    int level;
    
    public HealthItem(String aName, String aDescription, int l)
    {
        super(aName, aDescription);
        this.level = l;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setLevel(int l)
    {
        this.level = l;
    }
}
