import java.util.Scanner;

public class MainUmandana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kata biasa: ");
        String kataBiasa = scanner.nextLine();
        scanner.close();
        
        // Mengubah kata biasa menjadi bahasa Umandana
        String umandana = Umandana.toUmandana(kataBiasa);
        System.out.println("Kata dalam bahasa Umandana: " + umandana);
        
        // Mengembalikan kata Umandana ke bentuk normal
        String kataNormal = Umandana.deUmandana(umandana);
        System.out.println("Kata normal: " + kataNormal);
    }
}
