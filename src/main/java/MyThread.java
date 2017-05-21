import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class MyThread implements Runnable {
    private ConcurrentLinkedQueue<String> concurrentLinkedQueue;
    private String input;

    public MyThread(ConcurrentLinkedQueue<String> concurrentLinkedQueue){
        this.concurrentLinkedQueue = concurrentLinkedQueue;

    }

    public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                concurrentLinkedQueue.add("Record =" + i + ";");
                System.out.println("Add to queue: "+Thread.currentThread().getName());

        }
    }

}

