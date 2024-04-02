public class Umandana {
    /**
     * Mengembalikan kata yang telah diubah menjadi bahasa Umandana
     * Huruf a menjadi "aiden"
     * Huruf i menjadi "ipri"
     * Huruf u menjadi "upru"
     * Huruf e menjadi "epre"
     * Huruf o menjadi "opro"
     * Huruf mati yang tidak diikuti huruf vokal menjadi huruf tersebut + "es"
     * Suku kata "ng" yang tidak diikuti huruf vokal menjadi "strengen"
     * Suku kata "ng" yang diikuti huruf vokal tetap menjadi "ng"
     * Suku kata "ny" yang diikuti huruf vokal tetap menjadi "ny"
     * Selain ketentuan di atas, huruf/karakter tidak diubah
     * *
     * 
     * @param words
     * @return kata yang telah diubah menjadi bahasa Umandana
     * 
     */
      public static String toUmandana(String words) {
        StringBuilder bahasa = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            char currentChar = words.charAt(i);
            char nextChar = (i < words.length() - 1) ? words.charAt(i + 1) : '\0';
            
            if (currentChar == 'a') {
                bahasa.append("aiden");
            } else if (currentChar == 'i') {
                bahasa.append("ipri");
            } else if (currentChar == 'u') {
                bahasa.append("upru");
            } else if (currentChar == 'e') {
                bahasa.append("epre");
            } else if (currentChar == 'o') {
                bahasa.append("opro");
            } else if (currentChar == 'n' && nextChar == 'g'){
                if (i == words.length() - 2 || (!isVowel(words.charAt(i + 2)) || words.charAt(i + 2) == ' ')){
                    bahasa.append("strengen");
                    i++;
                }
                else {
                    bahasa.append("ng");
                    i++; 
                }
            } else if (currentChar == 'n' && nextChar == 'y' && (i == words.length() - 2 || isVowel(words.charAt(i + 2)))) {
                bahasa.append("ny");
                i++;
            } else if (currentChar != ' ' && currentChar != 'a' && currentChar != 'i' && currentChar != 'u' && currentChar != 'e' && currentChar != 'o' && !isVowel(nextChar)) {
                bahasa.append(currentChar).append("es");
            }
            else {
                bahasa.append(currentChar);
            }
        }
        return bahasa.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o';
    }

    /**
     * Mengembalikan kata Umandana ke bentuk normal
     * *
     * 
     * @param words kata dalam bahasa Umandana
     * @return kata telah diubah ke bentuk normal
     */
    public static String deUmandana(String words) {
        words = words.replaceAll("aiden", "a");
        words =  words.replaceAll("ipri","i");
        words = words.replaceAll("upru", "u");
        words = words.replaceAll("epre", "e");
        words = words.replaceAll("opro", "o");
        words = words.replaceAll("strengen", "ng");
        words = words.replaceAll("es", "");
        return words;
    }

}
