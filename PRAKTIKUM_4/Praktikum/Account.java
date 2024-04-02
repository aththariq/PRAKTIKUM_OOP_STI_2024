public class Account {
    private String username;
    private String password;

    /**
     * Account constructor
     * 
     * @param username
     * @param password
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Mengembalikan atribut username
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Mengembalikan atribut password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }
}