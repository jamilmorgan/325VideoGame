public class Hero extends Character {

    Integer Age;
    Integer Currency;
    Weapon Weapon;

    public Hero() {
        this.setDescription("You are the hero tasked with retrieving the Kingdom's National Treasure");
        this.setHealth(100);
        this.setCurrency(200);
        Weapon = new Weapon("Fists","A Strong punch with all of your might", 20);
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

