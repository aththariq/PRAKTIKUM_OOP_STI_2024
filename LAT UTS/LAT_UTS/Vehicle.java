package LAT_UTS;

public abstract class Vehicle implements Moveable {
    private static int numVehicle = 0;
    private GeoLoc loc;
    private int speed;

    public Vehicle(GeoLoc loc) {
        this.loc = loc;
        this.speed = 0;
        numVehicle++;
    }

    public GeoLoc getLocation() {
        return loc;
    }

    public static int getNumVehicle() {
        return numVehicle;
    }

    public abstract void accelerate();

    public abstract void decelerate();
}