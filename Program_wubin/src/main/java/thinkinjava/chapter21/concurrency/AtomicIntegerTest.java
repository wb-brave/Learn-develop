package thinkinjava.chapter21.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/07        wubin            0.0.1
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger();

    public int getI() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("aborting");
                System.exit(0);
            }
        }, 5000);
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(atomicIntegerTest);
        while (true) {
            int value = atomicIntegerTest.getI();
            if (value % 2 != 0) {
                System.out.print(value);
                System.exit(0);
            }
        }
    }

}
