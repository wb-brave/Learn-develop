package thinkinjava.chapter21.concurrency;

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
public class MutexEvenGenerator extends IntGenerator {

    private volatile int countDown = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();

        try {
            countDown++;
            Thread.yield();
            countDown++;
            return countDown;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
