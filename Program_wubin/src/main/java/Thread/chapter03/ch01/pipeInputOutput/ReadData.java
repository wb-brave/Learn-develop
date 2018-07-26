package Thread.chapter03.ch01.pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ReadData {
    public void writeMethod(PipedInputStream inputStream){
        try {
            System.out.println("read ");
            byte[] bytes = new byte[20];
            int byteLegth = inputStream.read(bytes);
            while (byteLegth!=-1){
                String newData = new String(bytes,0,byteLegth);
                System.out.print(newData);
                byteLegth = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
