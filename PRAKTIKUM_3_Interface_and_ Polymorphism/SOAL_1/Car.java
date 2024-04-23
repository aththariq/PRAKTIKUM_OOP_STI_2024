public class Car implements Vehicle, Door, Engine, Tyre {
    public void park() {
        System.out.println("Car park");
    }

    public void openDoor() {
        System.out.println("Car openDoor");
    }

    public void closeDoor() {
        System.out.println("Car closeDoor");
    }

    public void startEngine() {
        System.out.println("Car startEngine");
    }

    public void stopEngine() {
        System.out.println("Car stopEngine");
    }

    public void changeTyre() {
        System.out.println("Car changeTyre");
    }
}
