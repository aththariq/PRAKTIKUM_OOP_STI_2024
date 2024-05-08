/* Untuk mengaktifkan assertion, jalankan driver dengan flag -ea
   Contoh:
   $ javac Server.java ServerDriver.java
   $ java -ea ServerDriver
 */
public class ServerDriver {
    public static void main(String[] args) throws InterruptedException {
       int workers = 3;
       String[] req = {"Computer Science", "oversaturated", "distributed system", "designing data intensive application"};
       int nRequest = req.length;
       Server server = new Server(workers);

       Integer[] expectedWordCounts = {2, 3, 2, 4};
       Integer[] actualWordCounts = server.process(req);

       for (int i = 0; i < expectedWordCounts.length; i++) {
          assert (expectedWordCounts[i].equals(actualWordCounts[i])) == true;
       }
       System.out.println("Tidak ada error.");
    }
}
