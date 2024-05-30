import java.util.ArrayList;

public class AccountManager {
    private ArrayList<Account> accounts;

    /**
     * AccountManager constructor
     *
     * Menginisiasi ArrayList Account
     */
    public AccountManager() {
        accounts = new ArrayList<Account>();
    }

    /**
     * Mengecek apakah format username valid
     * Username dikatakan valid jika:
     * 1. Terdiri minimal dari 5 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     *
     * @param username username yang akan dicek
     * @return true jika sesuai ketentuan username yang valid
     */
    private static boolean isValidUsername(String username) {
        boolean digitorletter = false;

        for(int i = 0; i < username.length(); i++){
            if (Character.isLetterOrDigit(username.charAt(i))){
                digitorletter = true;
            }else{
                digitorletter = false;
                break;
            }
        }

        return (username.length() >= 5) && digitorletter;
    }

    /**
     * Mengecek apakah password merupakan password yang kuat
     * Password dikatakan kuat jika:
     * 1. Terdiri minimal dari 8 karakter
     * 2. Terdiri dari alfanumerik (huruf dan angka)
     * 3. Minimal terdiri dari 1 huruf dan 1 angka
     *
     * @param password password yang akan dicek
     * @return true jika sesuai ketentuan password yang kuat
     */
    private static boolean isStrongPassword(String password) {
        boolean digitorletter = false;

        boolean digit = false;
        boolean letter = false;

        for(int i = 0; i < password.length(); i++){
            if (Character.isLetterOrDigit(password.charAt(i))){
                digitorletter = true;
                if(Character.isDigit(password.charAt(i))){
                    digit = true;
                }else if (Character.isLetter(password.charAt(i))){
                    letter = true;
                }
            }else{
                digitorletter = false;
                break;
            }
        }

        return (password.length() >= 8) && digitorletter && digit && letter;
    }

    /**
     * Menambahkan akun baru ke dalam atribut accounts
     *
     * Akun dapat ditambahkan jika:
     * 1. Username valid, jika tidak valid maka
     * mencetak pesan "Username tidak valid"
     * 2. Username belum terdafta, jika terdaftar maka
     * mencetak pesan "Username telah digunakan"
     * 3. Password kuat, jika tidak kuat maka
     * mencetak pesan "Password tidak cukup kuat"
     *
     * Pengecekan dilakukan berurut berdasarkan penjelasan di atas
     * Apabila memenuhi syarat di atas, maka akun ditambahkan
     * dan password disimpan dalam format hash,
     * kemudian mencetak pesan "Akun berhasil didaftarkan"
     *
     * @param username username dari akun baru
     * @param password password dari akun baru dalam format tidak dihash
     */
    // AccountManager.java
    public void addAccount(String username, String password) {
        boolean sama = false;

        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                sama = true;
                break;
            }
        }

        if (!isValidUsername(username)) {
            System.out.println("Username tidak valid");
        } else if (sama) {
            System.out.println("Username telah digunakan");
        } else if (!isStrongPassword(password)) {
            System.out.println("Password tidak cukup kuat");
        } else {
            accounts.add(new Account(username, Ucrypt.hash(password)));
            System.out.println("Akun berhasil didaftarkan");
        }
    }

    /**
     * Masuk ke akun yang telah didaftarkan
     *
     * Apabila username akun tidak terdaftar
     * maka akan mencetak pesan "Akun tidak terdaftar"
     *
     * Apabila password akun salah
     * maka akan mencetak pesan "Password yang dimasukkan salah"
     *
     * Apabila username dan password sesuai
     * maka akan mencetak pesan "Berhasil masuk"
     *
     * @param username username dari akun
     * @param password password dari akun dalam format tidak dihash
     */
    public void login(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                if (Ucrypt.compare(password, account.getPassword())) {
                    System.out.println("Berhasil masuk");
                    return;
                } else {
                    System.out.println("Password yang dimasukkan salah");
                    return;
                }
            }
        }
        System.out.println("Akun tidak terdaftar");
    }
}
