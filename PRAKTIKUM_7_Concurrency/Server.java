public class Server {
    private int workers;

    Server(int workers) {
        this.workers = workers;
    }

    public Integer[] process(String[] requests) throws InterruptedException {
        Integer[] wordCounts = new Integer[requests.length];
        Thread[] threads = new Thread[workers]; // Menggunakan panjang requests

        // Inisialisasi semua elemen dalam array wordCounts dengan nilai 0
        for (int i = 0; i < wordCounts.length; i++) {
            wordCounts[i] = 0;
        }

        // Menggunakan loop yang iterasinya sesuai dengan panjang array requests
        for (int i = 0; i < workers; i++) {
            final int finalI = i;
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    for (int j = finalI; j < requests.length; j += workers) {
                        wordCounts[j] += count(requests[j]);
                    }
                }
                
            });
            threads[i].start();
        }

        for (int i = 0; i < workers; i++) {
            threads[i].join();
        }

        return wordCounts;
    }

    protected int count(String request) {
        request = request.trim();
        String[] words = request.split("\\s+");
        return words.length;
    }
}
