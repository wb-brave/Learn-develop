package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class StopThreadByReturnTest {

    @Test
    public void run() {

        try {

            StopThreadByReturn thread = new StopThreadByReturn();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}