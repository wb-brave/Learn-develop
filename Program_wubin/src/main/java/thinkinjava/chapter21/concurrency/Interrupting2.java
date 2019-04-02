package thinkinjava.chapter21.concurrency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/08
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/08        wubin            0.0.1
 */
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked2());
        // thread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("issuing t.interrupt()");
        //触发调用interrupt方法
        thread.interrupt();
    }
}

class BlockedMutex{

    private ReentrantLock lock = new ReentrantLock();

    public BlockedMutex() {
        //创建实例就开始加锁
        lock.lock();
    }
    public void f() {
        try {
            //这个方法不允许第二个task调用f(),会一直占有锁，除非被打断interupt()
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException from lock acquistion in f()");
        }
    }
}

class Blocked2 implements Runnable{

    BlockedMutex blockedMutex = new BlockedMutex();
    @Override
    public void run() {
        System.out.println("waiting for BlockedMutex.f()");
        blockedMutex.f();
        System.out.println("broken out of blocked2 call");
    }
}