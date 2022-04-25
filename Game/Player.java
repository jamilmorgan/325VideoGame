
public class Player extends Character implements Health{
    
    Weapon weapon, defaultW;
    int health;
    
    public Player(String aName, String aDescription, Location aRoom, Weapon aWeapon, int aHealth)
    {
        super(aName, aDescription, aRoom); 
        this.weapon = aWeapon;
        this.defaultW = aWeapon;
        this.health = aHealth;
    }
    
    public void setDefaultWeapon(Weapon w)
    {
        this.defaultW = w;
    }
    
    public Weapon getDefaultWeapon()
    {
        return defaultW;
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
