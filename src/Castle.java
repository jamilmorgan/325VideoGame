public class Castle extends Location {

    public Castle() {
        this.setLocationDescription("The Fortress is large and obsidian. The monster awaits inside the dome interior");
        this.setLocationName("Monster Fortress");
    }


        public String randomEncounter1 () {

            return "You Enter the obsidian and are greeted by the monster.\nThe National Treasure is behind it." +
                    "\nYou have no choice but to fight it in order to get it back.\nWill you fight?";
        }
        public String randomEncounter2 () {

            return null;
        }
        public String randomEncounter3 () {

            return null;
        }
        public String randomEncounter4 () {

            return null;
        }

    Integer WeatherEffectsOnHealth(Integer Health) {
        return 0;
    }
}
