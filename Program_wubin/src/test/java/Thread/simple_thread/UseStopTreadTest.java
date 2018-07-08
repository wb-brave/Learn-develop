package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class UseStopTreadTest {

    @Test
    public void run() {

        try {

            UseStopTread useStopTread = new UseStopTread();
            useStopTread.start();
            Thread.sleep(7000);
            System.out.println("main "+Thread.currentThread().getName());
            useStopTread.interrupt();
        }catch (InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}