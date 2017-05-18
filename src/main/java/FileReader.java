/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class FileReader {

    public static void main(String [] args){
        Thread t1=new Thread(new MyThreadForRead(),"A");
        Thread t2=new Thread(new MyThreadForRead(),"B");
        t1.start();
        t2.start();
    }
}
