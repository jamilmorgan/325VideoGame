abstract class Character {

    String Name;
    Integer Health;
    String [] Skills;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getHealth() {
        return Health;
    }

    public void setHealth(Integer health) {
        Health = health;
    }

    public String[] getSkills() {
        return Skills;
    }

    public void setSkills(String[] skills) {
        Skills = skills;
    }

    public abstract String attack(Integer Selection);
    //public abstract Integer guard();
}
