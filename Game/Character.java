
public class Character extends Thing {

    private Location location;

    public Character(String aName, String aDescription, Location aRoom) {
        super(aName, aDescription);
        location = aRoom;
    }

    public void setLocation(Location aRoom) {
        location = aRoom;
    }

    public Location getLocation() {
        return location;
    }
}
