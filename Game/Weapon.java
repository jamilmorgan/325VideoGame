
public class Weapon extends Thing{
    
    int damage;
    int i;
    
    public Weapon(String aName, String aDescription, int aDamage)
    {
        super(aName, aDescription);
        this.damage = aDamage;
    }
    
    public void setDamage(int d)
    {
        this.damage = d;
    }
    
    public int getDamage()
    {
        return damage;
    }
}
