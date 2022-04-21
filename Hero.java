public class Hero extends Character {

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void AssignSkills () {


    }

    @Override
    public String attack(Integer Selection) {

        String [] Skill = this.getSkills();

        return Skill[Selection];
    }
}
