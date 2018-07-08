package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyRunnableTest {

    @Test
    public void run() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}