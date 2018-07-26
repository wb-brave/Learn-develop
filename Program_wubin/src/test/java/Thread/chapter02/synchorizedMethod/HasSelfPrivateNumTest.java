package Thread.chapter02.synchorizedMethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class HasSelfPrivateNumTest {

    @Test
    public void run() {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        SycMethodThread1 thread1 = new SycMethodThread1(hasSelfPrivateNum);
        thread1.start();
        SycMethodThread2 thread2 = new SycMethodThread2(hasSelfPrivateNum);
        thread2.start();
    }
}