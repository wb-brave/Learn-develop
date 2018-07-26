package Thread.chapter03.ch01.pipeInputOutput;

import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream outputStream){
        try {
            System.out.println("write ");
            for (int i=0;i<300;i++){
                String data = ""+(i+1);
                outputStream.write(data.getBytes());
                System.out.print(data);
            }
            System.out.println();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
