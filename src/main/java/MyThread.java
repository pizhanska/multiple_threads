import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class MyThread implements Runnable {
    private ConcurrentLinkedQueue<String> concurrentLinkedQueue;
    private String input;

    public MyThread(ConcurrentLinkedQueue<String> concurrentLinkedQueue, String input){
        this.concurrentLinkedQueue = concurrentLinkedQueue;
        this.input = input;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        concurrentLinkedQueue.add(input);
    }
}
