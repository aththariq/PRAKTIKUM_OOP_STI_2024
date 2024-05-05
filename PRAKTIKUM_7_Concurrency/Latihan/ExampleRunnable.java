public class ExampleRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
