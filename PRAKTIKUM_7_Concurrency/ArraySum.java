/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 
import java.util.*;
<<<<<<< Updated upstream
import java.util.stream.IntStream;
=======
>>>>>>> Stashed changes

public class ArraySum {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 
<<<<<<< Updated upstream
    Thread[] threads;
=======
>>>>>>> Stashed changes

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
<<<<<<< Updated upstream
        int n = arr.length;
        nWorkers = Math.min(n, nWorkers);    
        int chunkSize = (int) Math.ceil((double) n / nWorkers);
        int[] sumArray = new int[nWorkers];
        
        Thread[] threads = new Thread[nWorkers];
        for (int i = 0; i < nWorkers; i++) {
            int finalStart = i * chunkSize;
            int finalEnd = Math.min((i + 1) * chunkSize, n);
            final int index = i;
        
            threads[i] = new Thread(() -> {
                int partialSum = partialSum(finalStart, finalEnd);
                synchronized (sumArray) {
                    sumArray[index] = partialSum;
                }
            });
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            thread.join();
        }
        
        return Arrays.stream(sumArray).sum();
}
=======
        int[] sum = {0};
        int n = arr.length;
        int chunkSize = n / nWorkers;
        int start = 0;
        int end = chunkSize;
        Thread[] threads = new Thread[nWorkers];
        
    
        for (int i = 0; i < nWorkers; i++) {
            if (i == nWorkers - 1) {
                end = n;
            }
    
            final int finalStart = start;
            final int finalEnd = end;
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    int partial = partialSum(finalStart, finalEnd);
                    synchronized (this) {
                    sum[0] += partial;
                    }
                }
            });
    
            threads[i].start();
        
            start = end;
            end += chunkSize;
        }
    
        for (int i = 0; i < nWorkers; i++) {
            threads[i].join();
        }
    
        return sum[0];
    }
>>>>>>> Stashed changes

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;
<<<<<<< Updated upstream
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
=======

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

>>>>>>> Stashed changes
        return sum;
    }
}