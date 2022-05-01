
public class Castle extends Location {

    MyLocale theLocale;
    
    public Castle(MyLocale loc) {
        
        theLocale = loc;
        
        this.setLocationDescription(theLocale.getLocaleWord("CASTLE_DESC"));
        this.setLocationName(theLocale.getLocaleWord("CASTLE_NAME"));
    }


        public String randomEncounter1 () {

            return (theLocale.getLocaleWord("CASTLE_ENC_1"));
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
