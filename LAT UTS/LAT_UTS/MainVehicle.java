package LAT_UTS;

public class MainVehicle {
    public void Main (String[] Args){
        Drone drone = new Drone(new GeoLoc(0, 0, 0));

        drone.accelerate();
        drone.decelerate();

        drone.climb();
        drone.descend();

        drone.moveTo(new GeoLoc(1, 1, 1));

        System.out.println("Jumlah kendaraan: " + Vehicle.getNumVehicle());
    }
    
}
