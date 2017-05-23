import java.io.*;
/**
 * Created by Uliana Pizhanska on 23/05/2017.
 */
public class MyFileReader {
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args){
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("ThreadDemo.txt")));
            new Thread(new ThreadForReading(bufferedReader)).start();
            new Thread(new ThreadForReading(bufferedReader)).start();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
