public abstract class Player implements Comparable<Player> {
    private String name;
    private int susLevel;
    private boolean frozen;
    private static Player[] players;

    public static final int DEFAULT_SUS_LEVEL = 15;

    /**
     * @param name Nama player
     * @param susLevel Representasi tingkat mencurigakan player
     *                 Nilai negatif akan dianggap sebagai 0 untuk minimum nilai.
     */
    public Player(String name, int susLevel) {
        this.name = name;
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
        if (players == null) {
            players = new Player[1];
            players[0] = this;
        } else {
            int length = players.length + 1;
            Player[] temp = players;
            players = new Player[length];
            for (int i = 0; i < temp.length; i++) {
                players[i] = temp[i];
            }
            players[players.length - 1] = this;
        }
    }

    /**
     * Metode abstract yang akan di-override oleh kelas anak dan akan digunakan
     * untuk emergency meeting.
     */
    // YOUR CODE HERE
    public abstract void emergencyMeeting();

    /**
     * Menggunakan Comparable interface.
     * Membandingkan dua objek Player berdasarkan susLevel
     * Mengembalikan nilai positif jika objek pembanding memiliki susLevel lebih rendah
     * Mengembalikan nilai negatif jika objek pembanding memiliki susLevel lebih tinggi
     * Mengembalikan 0 jika objek pembanding memiliki susLevel yang sama
     * @param p
     */
    @Override
    public int compareTo(Player p) {
        if (this.susLevel < p.susLevel) {
            return -1;
        } else if (this.susLevel > p.susLevel) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Metode untuk membandingkan dua objek Player berdasarkan kesamaan atribut.
     * @param o the other Player that you are comparing
     */
    public boolean equals(Object o) {
        if (o instanceof Player) {
            Player player = (Player) o;
            return this.name.equals(player.name) && this.frozen == player.frozen
                    && this.susLevel == player.susLevel;
        }
        return false;
    }

    /**
     * Metode untuk menampilkan informasi player.
     */
    public String toString() {
        String frozenString = frozen ? "frozen" : "not frozen";
        return "My name is " + this.name + ", and I have a susLevel of "
                + this.susLevel + ". I am currently " + frozenString + ".";
    }

    /**
     * Metode untuk mengecek apakah game sudah berakhir.
     * Metode ini akan dipanggil pada metode frozen maupun emergencyMeeting.
     */
    public boolean gameOver() {
        int impostorCount = 0;
        int crewmateCount = 0;
        for (Player p : players) {
            if (p instanceof Impostor && !p.frozen) {
                impostorCount++;
            } else if (p instanceof Crewmate && !p.frozen) {
                crewmateCount++;
            }
        }
        if (impostorCount == 0) {
            System.out.println("Crewmates Win!");
            return true;
        } else if (impostorCount >= crewmateCount) {
            System.out.println("Impostors Win!");
            return true;
        }
        return false;
    }

    /**
     * @return Nama player
     */
    public String getName() {
        return name;
    }

    /**
     * @return susLevel Player
     */
    public int getSusLevel() {
        return susLevel;
    }

    /**
     * Mengubah susLevel player, selalu bernilai positif.
     * @param susLevel
     */
    public void setSusLevel(int susLevel) {
        if (susLevel >= 0) {
            this.susLevel = susLevel;
        } else {
            this.susLevel = 0;
        }
    }

    /**
     * @return boolean apabila Player frozen
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Mengubah status frozen player
     * @param frozen
     */
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    /**
     * Metode untuk mendapatkan semua player yang ada.
     * @return Player[]
     */
    public static Player[] getPlayers() {
        return players;
    }

}
