import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Uliana Pizhanska on 23/05/2017.
 */
public class ThreadForReading implements Runnable {

    private BufferedReader reader;
    private String line = "";
    private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public ThreadForReading(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
            try {
                while ((line = reader.readLine()) != null) {
                    try {
                        queue.put(line);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            finally {
                try {
                    if (reader.readLine() == null & reader != null) {
                        reader.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                        System.out.println(queue.poll());
                        System.out.println("This thread gets element from queue: "+ Thread.currentThread().getName());
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(queue.size() == 0){
                    break;
                }
            }
        }
        }
    }


