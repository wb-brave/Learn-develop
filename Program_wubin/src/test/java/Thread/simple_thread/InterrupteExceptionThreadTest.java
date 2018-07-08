package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterrupteExceptionThreadTest {

    @Test
    public void run() {
        try {
            InterrupteExceptionThread thread = new InterrupteExceptionThread();
            thread.start();
            thread.interrupt();
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}