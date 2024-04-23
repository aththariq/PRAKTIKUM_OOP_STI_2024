public class MainWordProcessor {
    public static void main(String[] args) {
        // Membuat objek WordProcessor
        WordProcessor wordProcessor = new WordProcessor();

        // Menambahkan beberapa kata ke dalam daftar kata
        WordProcessor.addWord("Level");
        WordProcessor.addWord("hello");
        WordProcessor.addWord("java");

        // Mencetak daftar kata
        System.out.println("Daftar Kata:");
        WordProcessor.printWords();

        // Menguji apakah kata pada indeks tertentu merupakan palindrome
        int indexToCheck = 0; // Menggunakan indeks 0 (kata pertama) sebagai contoh
        if (WordProcessor.isPalindrome(indexToCheck)) {
            System.out.println("Kata pada indeks " + indexToCheck + " adalah palindrome.");
        } else {
            System.out.println("Kata pada indeks " + indexToCheck + " bukan palindrome.");
        }
    }
}
