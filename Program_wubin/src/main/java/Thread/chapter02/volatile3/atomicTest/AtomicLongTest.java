package Thread.chapter02.volatile3.atomicTest;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongTest{

    public static AtomicLong atomicLong = new AtomicLong();
    private static int i = 0;

    synchronized public void addNum() {

        System.out.println(Thread.currentThread().getName() + " + 100 后 " + atomicLong.addAndGet(100));

        atomicLong.addAndGet(1);
    }
}
