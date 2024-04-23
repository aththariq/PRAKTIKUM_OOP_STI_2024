public class Helicopter implements Vehicle, Door, Engine {
    public void park() {
        System.out.println("Airplane park");
    }

    public void openDoor() {
        System.out.println("Airplane openDoor");
    }

    public void closeDoor() {
        System.out.println("Airplane closeDoor");
    }

    public void startEngine() {
        System.out.println("Airplane startEngine");
    }

    public void stopEngine() {
        System.out.println("Airplane stopEngine");
    }
}
