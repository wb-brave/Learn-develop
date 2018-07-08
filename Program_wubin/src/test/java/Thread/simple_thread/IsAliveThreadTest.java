package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsAliveThreadTest {

    @Test
    public void run() {
        IsAliveThread isAliveThread = new IsAliveThread();
        Thread t = new Thread(isAliveThread);
        System.out.println("main  begin t.isAlive :" + t.isAlive());
        t.setName("wb");
        t.start();
        System.out.println("main  end t.isAlive :" + t.isAlive());
    }
}