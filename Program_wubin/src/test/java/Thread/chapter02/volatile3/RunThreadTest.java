package Thread.chapter02.volatile3;

import static org.junit.Assert.*;

public class RunThreadTest {

    public static void main(String[] wubin){
        RunThread runThread = new RunThread();
        runThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runThread.setFlag(false);
        System.out.println("fasle");
    }
}