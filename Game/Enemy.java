
public class Enemy extends Character implements Health{
    
    Weapon weapon;
    int health;
    boolean discovered;
    
    public Enemy(String aName, String aDescription, Location aRoom, Weapon aWeapon, int aHealth, boolean disc)
    {
        super(aName, aDescription, aRoom);
        this.weapon = aWeapon;
        this.health = aHealth;
    }
    
    public void setWeapon(Weapon w)
    {
        this.weapon = w;
    }
    
    public Weapon getWeapon()
    {
        return weapon;
    }
    
    public void setHealth(int h)
    {
        this.health = h;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setDiscovered(Boolean d)
    {
        this.discovered = d;
    }
    
    public boolean getDiscovered()
    {
        return discovered;
    }
    
     @Override
    public int removeHealth(int health, int damage)
    {
        health = health - damage;
        return health;
    }
    
    @Override
    public int addHealth(int health, int healthAdd)
    {
        health = health + healthAdd;
        return health;
    }
    
    @Override
    public boolean checkHealth(int health)
    {
        boolean alive;
        
        if(health <= 0)
        {
            alive = false;
        }
        else
        {
            alive = true;
        }
        
        return alive;
    }
}
