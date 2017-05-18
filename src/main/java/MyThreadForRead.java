import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uliana Pizhanska on 19/05/2017.
 */
public class MyThreadForRead implements Runnable {

    private static BufferedReader bufferedReader = null;
    private List<String> list;

    static {
        try {
            bufferedReader = new BufferedReader(new FileReader("ThreadDemo.txt"), 10);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        String line = null;
        int count = 0;
        while(true) {
            this.list = new ArrayList<String>();
            synchronized(bufferedReader) {
                try {
                    while((line = bufferedReader.readLine()) != null) {
                        if(count<15) {
                            list.add(line);
                            count++;
                        }else {
                            list.add(line);
                            count = 0;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1);
                display(this.list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(line == null)
                break;
        }


    }

    public void display(List<String> list) {
        for(String str:list) {
            System.out.println(str);
        }
    }
}
