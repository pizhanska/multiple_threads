import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class FileWriter {

    public static void main(String[] args) {
        File file=new File("ThreadDemo.txt");
        try {
            FileOutputStream out=new FileOutputStream(file, true);
            ConcurrentLinkedQueue<String> concurrentLinkedQueue=new ConcurrentLinkedQueue<String>();
            for(int i=0;i<10;i++){
                new Thread(new MyThread(concurrentLinkedQueue,"Thread  = " +i+"; " )).start();
            }
            Thread d = new Thread(new FileProcessing(out,concurrentLinkedQueue));
            Thread d1 = new Thread(new FileProcessing(out,concurrentLinkedQueue));
            d.start();
            d1.start();

            try {
                Thread.sleep(300);
                if(!Thread.currentThread().isAlive()){
                    System.out.println("The thread has finished");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
