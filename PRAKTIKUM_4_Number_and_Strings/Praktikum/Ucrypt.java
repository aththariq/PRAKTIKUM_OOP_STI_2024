public class Ucrypt {

    private static int hitungvokal(String word){
        int vokal = 0;
        for(char a : word.toCharArray()){
            if (a == 'a' || a == 'i' || a == 'u' || a == 'e' || a == 'o'){
                vokal ++;
            }
        }
        return vokal;
    }

    private static String numbertoalpha(String word){
        String hasil = word;

        hasil = hasil.replaceAll("0","a");
        hasil = hasil.replaceAll("1","b");
        hasil = hasil.replaceAll("2","c");
        hasil = hasil.replaceAll("3","d");
        hasil = hasil.replaceAll("4","e");
        hasil = hasil.replaceAll("5","f");
        hasil = hasil.replaceAll("6","g");
        hasil = hasil.replaceAll("7","h");
        hasil = hasil.replaceAll("8","i");
        hasil = hasil.replaceAll("9","j");

        return hasil;
    }

    private static char shift(char a){
        if(a == 'z'){
            return 'a';
        }else{
            return (char) (a + 1);
        }
    }

    public static String hash(String word) {
        StringBuilder hasil = new StringBuilder(numbertoalpha(Umandana.toUmandana(word)));

        int n = hitungvokal(word);

        for(int i = 0; i < hasil.length(); i++){
            for(int a = 0; a < n; a++){
                hasil.setCharAt(i, shift(hasil.charAt(i)));
            }
        }

        return hasil.toString();
    }

    public static boolean compare(String plain, String hashed) {
        return hash(plain).equals(hashed);
    }
}