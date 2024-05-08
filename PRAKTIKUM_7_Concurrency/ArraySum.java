/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 
import java.util.*;

public class ArraySum {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 
    Thread[] threads;

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
        int[] sum = {0};
        int n = arr.length;
        int chunkSize = (int) Math.floor((double)n / nWorkers);
        int start = 0;
        int end = chunkSize;
        

        
        try {
        for (int i = 0; i < nWorkers; i++) {
            if (i == nWorkers - 1) {
                end = n;
            }
            this.threads = new Thread[nWorkers];
            int finalStart = start;
            int finalEnd = end;
            threads[i] = new Thread(() -> {
                synchronized (this) {
                int partial = partialSum(finalStart, finalEnd);
                sum[0] += partial;
            }});
    
            threads[i].start();
    
            start = end;
            end += chunkSize;
        }
    
        for (int i = 0; i < nWorkers; i++) {
            threads[i].join();
        }
    } catch (InterruptedException e) {
        throw new InterruptedException();
    }
        return sum[0];
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}