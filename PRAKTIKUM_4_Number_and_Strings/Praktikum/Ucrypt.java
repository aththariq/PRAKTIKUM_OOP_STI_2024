public class Ucrypt {

    /**
     * Mengembalikan string yang telah dihash
     * 
     * Hash dilakukan dengan cara:
     * 1. Mengubah kata menjadi bahasa Umandana
     * 2. Menggeser karakter sebanyak huruf vokal pada kata awal
     * 3. Apabila karakter merupakan digit angka maka:
     * 3.1 Digit diubah menjadi huruf kecil sesuai urutan alfabet (a urutan ke-0)
     * 3.2 Karakter kemudian digeser sebanyak huruf vokal pada kata awal
     * Contoh: hash(tes123) = tepreses123 -> ufqsftftcde
     * 
     * @param word kata yang akan dihash
     * @return kata yang telah dihash
     */

    public static String hash(String word) {
        String kata = Umandana.toUmandana(word);
        StringBuilder baru = new StringBuilder(kata);

        int countVokal = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o') {
                countVokal++;
            }
        }
        for (int j = 0; j < baru.length(); j++) {
            char ch = baru.charAt(j);
            if (Character.isDigit(ch)) {
                baru.setCharAt(j, (char) (((ch - '0') + 'a' + countVokal) % 26 + 'a'));
            } else if (Character.isLowerCase(ch)) {
                baru.setCharAt(j, (char) (((ch - 'a') + countVokal) % 26 + 'a'));
            }
        }
        return baru.toString();
    }

    /**
     * Mengecek apakah parameter hashed merupakan parameter plain yang telah dihash
     * 
     * @param plain  kata sebelum dihash
     * @param hashed kata setelah dihash
     * @return true apabila hashed merupakan plain yang telah dihash
     */
    public static boolean compare(String plain, String hashed) {
        return hash(plain).equals(hashed);
    }
}
