import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class FileProcessing implements Runnable {

    private FileOutputStream outputStream;
    private ConcurrentLinkedQueue<String> concurrentLinkedQueue;

    public FileProcessing() {
    }

    public FileProcessing(FileOutputStream outputStream, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        this.outputStream = outputStream;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public void run() {
        synchronized (concurrentLinkedQueue) {
            while (true){
                System.out.println(Thread.currentThread().getName());
                if (!concurrentLinkedQueue.isEmpty()) {
                    try {
                        outputStream.write(concurrentLinkedQueue.poll().getBytes());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (concurrentLinkedQueue.isEmpty()){
                    break;
                }

          }
        }

    }
}
