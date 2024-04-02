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
    public static StringBuilder hash(String word) {
        String umandanaWord = Umandana.toUmandana(word);
        StringBuilder hashed = new StringBuilder();
        int vowelCount = 0;
        for (int i = 0; i < umandanaWord.length(); i++) {
            char currentChar = umandanaWord.charAt(i);
            if (currentChar == 'a' || currentChar == 'i' || currentChar == 'u' || currentChar == 'e' || currentChar == 'o') {
                vowelCount++;
            }
            if (Character.isDigit(currentChar)) {
                char newChar = (char) ('a' + (currentChar - '0' + vowelCount) % 26);
                hashed.append(newChar);
            } else {
                hashed.append(currentChar);
            }
        }
        return hashed;
    }

    /**
     * Mengecek apakah parameter hashed merupakan parameter plain yang telah dihash
     * 
     * @param plain  kata sebelum dihash
     * @param hashed kata setelah dihash
     * @return true apabila hashed merupakan plain yang telah dihash
     */
    public static boolean compare(String plain, String hashed) {
        return hash(plain).toString().equals(hashed);
    }
}
