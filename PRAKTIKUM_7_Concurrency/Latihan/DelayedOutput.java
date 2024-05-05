public class DelayedOutput{
    public static void printDelayed(long Time, String message){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    Thread.sleep(Time);
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}