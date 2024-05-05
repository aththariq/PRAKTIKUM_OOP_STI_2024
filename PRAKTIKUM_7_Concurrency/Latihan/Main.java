import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        int balance = scanner.nextInt();
        int Q = scanner.nextInt();
        // Inisialisasi DebitCard
        DebitCard debitCard = new DebitCard(balance);
        // Inisialisasi dan start semua thread transaksi
        Thread[] threads = new Thread[Q];
        for (int i = 0; i < Q; i++) {
            String transactionType = scanner.next();
            int amount = scanner.nextInt();
            if (transactionType.equals("W")) {
                threads[i] = new Thread(() -> debitCard.withdraw(amount));
            } else if (transactionType.equals("D")) {
                threads[i] = new Thread(() -> debitCard.deposit(amount));
            }
            threads[i].start();
        }
        // Tunggu sampai semua thread selesai
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Cetak riwayat transaksi
        debitCard.printTransactionsHistory();
        scanner.close();
    }
}
