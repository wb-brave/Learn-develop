package thinkinjava.chapter21.concurrency;

import java.io.*;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/21        wubin            0.0.1
 */
public class TestBlockingQueue {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner liftOffRunner = new LiftOffRunner(queue);
        Thread thread = new Thread(liftOffRunner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            liftOffRunner.add(new LiftOff());
        }
        getKey("press 'Enter' (" + msg + ")");
        thread.interrupt();
        System.out.println("finish" + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingDeque",new LinkedBlockingDeque<LiftOff>());
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<LiftOff>());
    }
}

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("interrupted in put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff liftOff = rockets.take();
                liftOff.run();
            }
        } catch (InterruptedException e) {
            System.out.println("waking from take()");
        }
        System.out.println("Exiting liftoffRunner");
    }
}