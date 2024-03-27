class Parent {
    void print() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void print() {
        System.out.println("Child");
    }
}

public class override {
    public static void main(String[] args) {
        Parent parent = new Child(); // Casting Child ke Parent
        parent.print(); // Memanggil metode print()
    }
}
