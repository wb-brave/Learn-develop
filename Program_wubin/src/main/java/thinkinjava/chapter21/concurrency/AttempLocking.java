package thinkinjava.chapter21.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/04        wubin            0.0.1
 */
public class AttempLocking {

    private Lock lock = new ReentrantLock();

    public void untime() {
        boolean locked = lock.tryLock();
        try {
            System.out.println("lock.tryLock(): " + locked);
        } finally {
            if (locked) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("lock.tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttempLocking attempLocking = new AttempLocking();
        attempLocking.untime();
        attempLocking.timed();
        /**
         * 创建另外的线程去竞争锁
         */
        new Thread(){
            {setDaemon(true);}

            @Override
            public void run() {

                attempLocking.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        attempLocking.untime();
        attempLocking.timed();

    }
}
