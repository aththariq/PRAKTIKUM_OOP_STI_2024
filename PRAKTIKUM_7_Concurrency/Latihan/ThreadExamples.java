public class ThreadExamples {
    public static void main(String[] args) {
        // ExampleThread thread1 = new ExampleThread();
        // thread1.start();
        //thread1.run();

        Thread thread2 = new Thread(new ExampleRunnable());
        thread2.start();
    }
}