import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static List<Integer> a;
    private static boolean n = false; 
    private String s;
    private boolean b;

    // constructor
    public MyThread(String s, boolean b) {
        this.s = s;
        this.b = b;
    }

    static {
        a = new ArrayList<Integer>();
        for (int i=0; i<5; i++) a.add(i);
    }

    // run
    /* public void run() {
        for (int i=0; i<5; i++) {
            while (b != n) {
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized(lock1) {
                print(i);
                n = !n;
            }
        }
    } */

    public void run() {
        synchronized(lock1) {
            for (int i=0; i<5; i++) {
                print(i);
            }
        }
    }

    // print
    public void print(int i) {
        synchronized(lock2) {
            System.out.format("%s; %s%n", s, a.get(i));
        }
    }
}

