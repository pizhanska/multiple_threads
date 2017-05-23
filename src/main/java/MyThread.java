import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class MyThread implements Runnable {
    private ConcurrentLinkedQueue<String> concurrentLinkedQueue;


    public MyThread(ConcurrentLinkedQueue<String> concurrentLinkedQueue){
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public void run() {
            for (int i = 0; i < 30; i++) {
                concurrentLinkedQueue.add("Record =" + i + "\n");
                System.out.println("This thread adds to queue: "+Thread.currentThread().getName());

        }
    }

}

