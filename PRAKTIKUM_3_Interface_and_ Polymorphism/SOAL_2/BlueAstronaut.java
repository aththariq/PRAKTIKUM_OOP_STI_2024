import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    // Atribut jumlah task yang harus diselesaikan (integer)
    private int numTasks;

    // Atribut kecepatan menyelesaikan task (integer, nonzero positive)
    private int taskSpeed;

    // Atribut untuk mengecek apakah task sudah selesai pertama kali
    private boolean taskselesai = false;

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
        // Isi variabel numTasks dan taskSpeed dengan parameter yang sesuai
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    /*

    */
    public void emergencyMeeting() {
        if(!(this.isFrozen())){
            int maxsuslevel = -1;
            int a = 0;
            boolean adayangsama = false;
            for(int i = 0; i < Player.getPlayers().length; i++){
                if ((!(Player.getPlayers()[i].isFrozen()))){
                    if (Player.getPlayers()[i].getSusLevel() > maxsuslevel ){
                        maxsuslevel = Player.getPlayers()[i].getSusLevel();
                        a = i;
                        adayangsama = false;
                    }else if (Player.getPlayers()[i].getSusLevel() == maxsuslevel){
                        adayangsama = true;
                    }
                }
            }

            if ((!(adayangsama)) && (maxsuslevel != -1)){
                Player.getPlayers()[a].setFrozen(true);
            }

            this.gameOver();
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
        if(!this.isFrozen()){
            if(numTasks == 0 && (!taskselesai)){
                this.taskselesai = true;
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int) (getSusLevel()*0.5));
            }else{
                if(taskSpeed > 20){
                    if(numTasks>=2){
                        numTasks -= 2;
                    }else{
                        numTasks = 0;
                    }
                }else{
                    if(numTasks>=1){
                        numTasks -= 1;
                    }else{
                        numTasks = 0;
                    }
                }
            }
        }
        
    }

    /*
        * Dua BlueAstronaut sama jika mereka keduanya memiliki nama yang sama, frozen, susLevel, numTasks, dan taskSpeed
        * Mengembalikan sebuah boolean.
    */
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut){
            BlueAstronaut objek = (BlueAstronaut) o;
            return (super.equals(o)) && (this.numTasks == objek.numTasks) && (taskSpeed == objek.taskSpeed);
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
        if(this.getSusLevel() > 15){
            return (super.toString() + " I have " + numTasks + " left over.").toUpperCase();
        }

        return super.toString() + " I have " + numTasks + " left over.";
    }
}
