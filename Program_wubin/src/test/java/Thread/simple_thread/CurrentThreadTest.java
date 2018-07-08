package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentThreadTest {

    @Test
    public void run() {
        CurrentThread currentThread = new CurrentThread();
//        currentThread.start();
        currentThread.run();
    }
}