public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("T1", true));
        Thread t2 = new Thread(new MyThread("T2", false));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}