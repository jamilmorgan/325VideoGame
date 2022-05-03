
public class Enemy extends Character {

    Integer DamageDealt;
    public Enemy (String Name, String Description, Integer Health, Integer DamageDealt){
        this.setName(Name);
        this.setHealth(Health);
        this.setDescription(Description);
        this.setDamageDealt(DamageDealt);

    }

    public Integer getDamageDealt() {
        return DamageDealt;
    }

    public void setDamageDealt(Integer damageDealt) {
        DamageDealt = damageDealt;
    }
}
