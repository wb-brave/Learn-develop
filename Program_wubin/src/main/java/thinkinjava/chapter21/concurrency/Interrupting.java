package thinkinjava.chapter21.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 中断所有or单个线程（sleep可以被中断，但是被synchronized或io操作则不能被中断）
 * 一般都是中断处于阻塞时期的线程，但是也可以使使用方法来中断正常线程
 *  if (Thread.currentThread().isInterrupted()) {
 * System.out.println("Interrupted from IO Blocked");
 * }
 * 当在一个线程上调用interrupt()时，中断发生的唯一时刻是在任务要进入阻塞操作中
 *  或者已经在在阻塞中
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/07        wubin            0.0.1
 */
public class Interrupting {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> submit = executorService.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("interrupting: " + r.getClass().getSimpleName());
        submit.cancel(true);
        System.out.println("Interrupt send to " + r.getClass().getSimpleName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("abort with System exit(0)");
        System.exit(0);
    }
}

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from IO Blocked");
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(() -> f()).start();
    }

    @Override
    public void run() {
        System.out.println("tring to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}
