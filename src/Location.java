abstract class Location {
    String LocationName;
    String LocationDescription;
    String LocationTemp;

    abstract Integer WeatherEffectsOnHealth (Integer Health);

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public String getLocationDescription() {
        return LocationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        LocationDescription = locationDescription;
    }

    public String getLocationTemp() {
        return LocationTemp;
    }

    public void setLocationTemp(String locationTemp) {
        LocationTemp = locationTemp;
    }

    abstract String randomEncounter1();
    abstract String randomEncounter2();
    abstract String randomEncounter3();
    abstract String randomEncounter4();
}
