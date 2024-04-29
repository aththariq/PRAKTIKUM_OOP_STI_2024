/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class Account {
    /**
     * Tambahkan atribut kelas disini
     */ 
    private String name;
    private int balance;

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     * Atribut nama harus memiliki panjang karakter antara 3-20 karakter (inklusif)
     * Apabila nama tidak memenuhi ketentuan tersebut, akan dilempar exception "Nama pengguna harus terdiri dari 3-20 karakter"
     * Atribut balance/saldo tidak boleh bernilai negatif
     * Apabila tidak memenuhi ketentuan tersebut, akan dilempar exception "Tidak dapat membuat akun dengan saldo negatif"
     */
    public Account(String name, int balance) {
        if(name.length() < 3 || name.length() > 20) throw new IllegalArgumentException("Nama pengguna harus terdiri dari 3-20 karakter");
        if(balance < 0) throw new IllegalArgumentException("Tidak dapat membuat akun dengan saldo negatif");
        this.name = name;
        this.balance = balance;
    }

    /**
     * Implementasi
     * return nama
     */
    public String getName() {
        return name;
    }


    /**
     * Implementasi
     * return balance/saldo
     */
    public int getSaldo() {
        return balance;
    }

    /**
     * Amount harus bernilai positif. Apabila tidak memenuhi, akan dilempar exception "Jumlah saldo yang ditambahkan harus lebih dari 0"
     * 
     * Implementasi
     * menambahkan amount ke balance/saldo
     */
    public void addSaldo(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Jumlah saldo yang ditambahkan harus lebih dari 0");
        else balance += amount;
    }

    /**
     * Amount harus bernilai positif. Apabila tidak memenuhi, akan dilempar exception "Jumlah saldo yang dikurangkan harus lebih dari 0"
     * Apabila saldo tidak mencukupi, akan dilempar exception "Saldo tidak mencukupi"
     * 
     * Implementasi
     * mengurangkan amount ke balance/saldo
     */
    public void reduceSaldo(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Jumlah saldo yang dikurangkan harus lebih dari 0");
        if (balance < amount) throw new IllegalArgumentException("Saldo tidak mencukupi");
        else balance -= amount;
    }
}