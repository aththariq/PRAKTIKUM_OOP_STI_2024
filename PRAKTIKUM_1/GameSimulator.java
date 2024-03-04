import java.util.Scanner;

public class GameSimulator {
    private static int i = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int jumlahPemain = Integer.parseInt(input.nextLine());
        String namaSeeker = input.nextLine();

        System.out.printf("Game dimulai dengan %d pemain, seeker adalah %s\n", jumlahPemain, namaSeeker);


        while (i < jumlahPemain-1){
            int foundPemain = Integer.parseInt(input.nextLine());
            if ((foundPemain-i)==1){
                i++;
                System.out.printf("%d Pemain ditemukan\n", i);
            }
        }

        input.close();

        System.out.println("Semua pemain telah ditemukan, permainan selesai.");
    }
}
