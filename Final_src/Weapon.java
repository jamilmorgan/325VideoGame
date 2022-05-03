
public class Weapon {

    public String WeaponName;
    public String WeaponDescription;
    public Integer DamageDealt;

    public Weapon (String Name, String Desc, Integer Damage){
        this.setWeaponName(Name);
        this.setWeaponDescription(Desc);
        this.setDamageDealt(Damage);
    }

    public String getWeaponName() {
        return WeaponName;
    }

    public void setWeaponName(String weaponName) {
        WeaponName = weaponName;
    }

    public String getWeaponDescription() {
        return WeaponDescription;
    }

    public void setWeaponDescription(String weaponDescription) {
        WeaponDescription = weaponDescription;
    }

    public Integer getDamageDealt() {
        return DamageDealt;
    }

    public void setDamageDealt(Integer damageDealt) {
        DamageDealt = damageDealt;
    }
}
