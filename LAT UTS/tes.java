import java.util.Scanner;

public class tes{
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        
        // Meminta pengguna untuk memasukkan beberapa kata
        System.out.println("Masukkan beberapa kata (pisahkan dengan spasi):");

        // Memeriksa apakah masih ada token input yang belum dibaca
        while (scanner.hasNext()) {
            // Jika masih ada token, baca token tersebut dan tampilkan
            String token = scanner.next();
            System.out.println("Token yang dibaca: " + token);
        }

        // Setelah tidak ada token input lagi, tampilkan pesan
        System.out.println("Tidak ada token input lagi.");
        
        // Menutup Scanner
        scanner.close();
    }
}
