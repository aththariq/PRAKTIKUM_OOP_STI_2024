public class Motorcycle implements Vehicle, Engine, Tyre {
    public void park() {
        System.out.println("Motorcycle park");
    }

    public void startEngine() {
        System.out.println("Motorcycle startEngine");
    }

    public void stopEngine() {
        System.out.println("Motorcycle stopEngine");
    }

    public void changeTyre() {
        System.out.println("Motorcycle changeTyre");
    }
}
