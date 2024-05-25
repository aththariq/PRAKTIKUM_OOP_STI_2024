<<<<<<< Updated upstream
/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac ArraySum.java ArraySumDriver.java
   $ java -ea ArraySumDriver
 */
public class ArraySumDriver {
    public static void main(String[] args) throws InterruptedException {
       int nWorkers = 3;
       Integer[] arr = {1, 2, 3, 4, 5};

       ArraySum arraySum = new ArraySum(nWorkers, arr);

       Integer expectedArraySum = 15;
       Integer actualArraySum = arraySum.sum();

       assert expectedArraySum == actualArraySum;

       System.out.println("Yeay! Program berhasil :D");
    }
=======
public class ArraySumDriver {
   public static void main(String[] args) throws InterruptedException {
       int nWorkers = 3;
       Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};

       ArraySum arraySum = new ArraySum(nWorkers, arr);

       Integer expectedArraySum = 45; // Penjumlahan dari 1 sampai 9
       Integer actualArraySum = arraySum.sum();

       assert expectedArraySum.equals(actualArraySum);

       System.out.println("Yeay! Program berhasil :D");
   }
>>>>>>> Stashed changes
}
