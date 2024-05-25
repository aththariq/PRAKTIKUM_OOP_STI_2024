/**
 * DelayedOutput.java 
 * [Jelaskan kegunaan class ini]
 * @author [18222013] [Aththariq Lisan]
 */
public class DelayedOutput {
    public static void printDelayed(int delayMillisec, String output) {
        // TODO print output setelah di delay selama delayMillisec
        // PENTING: gunakan threading agar tidak blocking
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(delayMillisec);
                System.out.println(output);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
<<<<<<< Updated upstream
}
=======
  }
>>>>>>> Stashed changes
