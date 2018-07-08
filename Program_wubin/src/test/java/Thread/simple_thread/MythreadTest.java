package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class MythreadTest {

    @Test
    public void run() {
        Mythread mythread = new Mythread();
        mythread.start();
        System.out.println("over");
    }
}