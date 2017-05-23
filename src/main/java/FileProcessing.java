import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class FileProcessing implements Runnable {

    private FileOutputStream outputStream;
    private ConcurrentLinkedQueue<String> concurrentLinkedQueue;

    public FileProcessing(FileOutputStream outputStream, ConcurrentLinkedQueue<String> concurrentLinkedQueue) {
        this.outputStream = outputStream;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
    }

    public void run() {
            while (true) {
                synchronized (concurrentLinkedQueue) {
                if (!concurrentLinkedQueue.isEmpty()) {

                    try {
                        outputStream.write(concurrentLinkedQueue.poll().getBytes());
                        System.out.println("This thread writes to file : "+ Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
              try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(concurrentLinkedQueue.size() == 0){
                    break;
                }

            }
        }
        }

    }

