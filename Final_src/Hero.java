
public class Hero extends Character {

    Integer Age;
    Integer Currency;
    Weapon Weapon;
    
    MyLocale theLocale;

    public Hero(MyLocale loc) {
        
        theLocale = loc;
        
        this.setDescription(theLocale.getLocaleWord("HERO_DESC"));
        this.setHealth(70);
        this.setCurrency(200);
        Weapon = new Weapon(theLocale.getLocaleWord("FIST_NAME"),theLocale.getLocaleWord("FIST_DESC"), 20);
    }


    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Integer getCurrency() {
        return Currency;
    }

    public void setCurrency(Integer currency) {
        Currency = currency;
    }

    public Weapon getWeapon() {
        return Weapon;
    }

    public void setWeapon(Weapon weapon) {
        Weapon = weapon;
    }
}
