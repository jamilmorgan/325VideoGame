public class Location extends Thing {

    Weapon weapon;
    HealthItem healthItem;
    Enemy enemy;
    private int n, s, w, e;

    public Location(String aName, String aDescription, Weapon aWeapon, HealthItem aHealthItem, Enemy aEnemy, int aN, int aS, int aW, int aE) {
        super(aName, aDescription);
        this.weapon = aWeapon;
        this.healthItem = aHealthItem;
        this.enemy = aEnemy;
        n = aN;
        s = aS;
        w = aW;
        e = aE;
    }


    public Weapon getWeapon()
    {
        return weapon;
    }
    
    public void setWeapon(Weapon w)
    {
        this.weapon = w;
    }
    
    public HealthItem getHealthItem()
    {
        return healthItem;
    }
    
    public void setHealthItem(HealthItem h)
    {
        this.healthItem = h;
    }
    
    public Enemy getEnemy()
    {
        return enemy;
    }
    
    public void setEnemy(Enemy e)
    {
        this.enemy = e;
    }
    public int getN() {
        return n;
    }

    public void setN(int aN) {
        n = aN; 
    }

    // s
    public int getS() {
        return s;
    }

    public void setS(int aS) {
        s = aS;
    }

    // e
    public int getE() {
        return e;
    }

    public void setE(int aE) {
        e = aE;
    }

    // w
    public int getW() {
        return w;
    }

    void setW(int aW) {
        w = aW;
    }
}
