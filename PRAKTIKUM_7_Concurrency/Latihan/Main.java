class MyThread extends Thread {
    public void run() {
        System.out.println("Hello from thread!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Memulai eksekusi thread
    }
}
