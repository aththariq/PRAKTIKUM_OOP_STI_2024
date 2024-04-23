import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Atribut jumlah task yang harus diselesaikan (integer)
    private int numTasks;

    // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
    private int taskSpeed;

    // Atribut untuk mengecek apakah task sudah selesai pertama kali
    private boolean firstTimeTask;

    // Atribut DEFAULT_NUM_TASKS bertipe data int dengan nilai 6
    private static final int DEFAULT_NUM_TASKS = 6;

    // Atribut DEFAULT_TASK_SPEED bertipe data int dengan nilai 10
    private static final int DEFAULT_TASK_SPEED = 10;

    public BlueAstronaut(String name) {
        // Panggil constructor dengan parameter name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, dan DEFAULT_TASK_SPEED
        this(name, DEFAULT_SUS_LEVEL, DEFAULT_NUM_TASKS, DEFAULT_TASK_SPEED);
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        // Panggil constructor dari superclass dengan parameter name dan susLevel
        super(name, susLevel);
        // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    /*

    */
    public void emergencyMeeting() {
        if (!isFrozen()) {
            Player highestSus = null;
            for (Player p : getPlayers()) {
                if (!(p instanceof Impostor) && !p.isFrozen()) {
                    if (highestSus == null || p.compareTo(highestSus) > 0) {
                        highestSus = p;
                    }
                }
            }
            if (highestSus != null) {
                highestSus.setFrozen(true);
            }
            gameOver();
        }
    }

    /*
        * BlueAstronaut yang frozen tidak dapat menyelesaikan tugas.
        * Jika taskSpeed lebih besar dari 20, kurangi numTasks sebanyak 2. Jika tidak, kurangi 1 dari numTasks.
            * Jika numTasks turun di bawah 0, tetapkan menjadi 0
        * Setelah BlueAstronaut selesai dengan tugas mereka, yang berarti numTasks sama dengan 0 (hanya untuk pertama kali),
            * Cetak `"I have completed all my tasks"`
            * Kemudian kurangi susLevel BlueAstronaut sebesar 50% (dibulatkan ke bawah)
        * Tidak mengembalikan apapun.
    */
    public void completeTask() {
        if (!isFrozen()) {
            if (taskSpeed > 20) {
                numTasks -= 2;
            } else {
                numTasks -= 1;
            }
            if (numTasks < 0) {
                numTasks = 0;
            }
            if (numTasks == 0 && !firstTimeTask) {
                System.out.println("I have completed all my tasks");
                setSusLevel((int) Math.floor(getSusLevel() * 0.5));
                firstTimeTask = true;
            }
        }
    }

    /*
        * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen, susLevel, numTasks, dan taskSpeed
        * Mengembalikan sebuah boolean.
    */
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut b = (BlueAstronaut) o;
            return getName().equals(b.getName()) && isFrozen() == b.isFrozen() && getSusLevel() == b.getSusLevel() && numTasks == b.numTasks && taskSpeed == b.taskSpeed;
        }
        return false;
    }

    /*
        Mengembalikan String yang menggambarkan BlueAstronaut sebagai berikut:
        * `"My name is [name], and I have a `susLevel` of [susLevel]. I am currently (frozen / not frozen). I have [numTasks] left over."`
            * Jika susLevel lebih besar dari 15, kembalikan keluaran dalam huruf kapital semua. (Hint: toUppercase)
            * (Note: gantikan nilai dalam tanda kurung [] dengan nilai sebenarnya)
        * Anda harus menggunakan metode toString() dari kelas Player.
    */
    public String toString() {
        String output = super.toString() + " I have " + numTasks + " left over.";
        if (getSusLevel() > 15) {
            return output.toUpperCase();
        }
        return output;
    }
}
