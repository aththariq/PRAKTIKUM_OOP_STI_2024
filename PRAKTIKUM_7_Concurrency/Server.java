import java.util.*;

public class Server {
    private int workers;

    Server(int workers) {
        this.workers = workers;
    }

    public Integer[] process(String[] requests) throws InterruptedException {
        Integer[] wordCounts = new Integer[requests.length];
        Arrays.fill(wordCounts, 0);
        Thread[] threads = new Thread[workers]; 
    
        int baseReqPerWorker = requests.length / workers;
        int extraReq = requests.length % workers;
    
        int start = 0;
        for (int i = 0; i < workers; i++) {
            final int finalStart = start;
            int reqForThisWorker = baseReqPerWorker + (i < extraReq ? 1 : 0);
            final int finalEnd = finalStart + reqForThisWorker;
    
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    for (int j = finalStart; j < finalEnd; j++) {
                        int localCount = count(requests[j]);
                        synchronized (wordCounts) {
                            wordCounts[j] += localCount;
                        }
                    }
                }
            });
            threads[i].start();
    
            start = finalEnd;
        }
    
        for (int i = 0; i < workers; i++) {
            threads[i].join();
        }
    
        return wordCounts;
    }

    protected synchronized int count(String request) {
        request = request.trim();
        String[] words = request.split("\\s");
        long wordCount = Arrays.stream(words)
                               .filter(word -> !word.isEmpty())
                               .count();
        return (int) wordCount;
    }
}
