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

public class overrideDua {
    public static void main(String[] args) {
        // Casting Child ke Parent
        Parent parent = new Child();

        // Memanggil metode print() dari parent
        parent.print();
    }
}
