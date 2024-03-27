package LAT_UTS;

public class Drone extends Vehicle{
    private int vSpeed;

    public Drone(GeoLoc loc) {
        super(loc);
    }

    @Override
    public void moveTo(GeoLoc newLoc) {
        newLoc.setLoc(newLoc.getLat(), newLoc.getLon(), newLoc.getAlt());
    }

    public void climb(){
        GeoLoc currentLoc = getLocation();
        currentLoc.setLoc((currentLoc.getAlt() + 1), currentLoc.getLon(), currentLoc.getAlt());
    }

    public void descend(){
        GeoLoc currentLoc = getLocation();
        currentLoc.setLoc((currentLoc.getAlt() - 1), currentLoc.getLon(), currentLoc.getAlt());
    }

    @Override
    public void accelerate() {
        vSpeed += 1;
    }

    @Override
    public void decelerate() {
        vSpeed -= 1;
    }
}
