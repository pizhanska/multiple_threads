import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class FileWriter {

    public static void main(String[] args) {
        File file=new File("ThreadDemo.txt");
        if(file.exists()){
            try {
                FileUtils.forceDelete(file);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream out=new FileOutputStream(file, true);
            ConcurrentLinkedQueue<String> concurrentLinkedQueue=new ConcurrentLinkedQueue<String>();
            Thread t1 = new Thread(new MyThread(concurrentLinkedQueue));
            Thread t2 = new Thread(new MyThread(concurrentLinkedQueue));
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            new Thread(new FileProcessing(out,concurrentLinkedQueue)).start();
            new Thread(new FileProcessing(out,concurrentLinkedQueue)).start();
            try {
                Thread.sleep(300);
                if(!Thread.currentThread().isAlive()){
                    System.out.println("The thread has finished");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
