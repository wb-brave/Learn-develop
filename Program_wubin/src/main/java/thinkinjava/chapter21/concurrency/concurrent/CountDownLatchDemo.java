package thinkinjava.chapter21.concurrency.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 并发包下的工具类，其作用是同步一个或多个任务，强制等待有其他任务指定给的一组操作完成
 * 当countdownlatch为0时，等待的线程开始执行
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class CountDownLatchDemo {

    static final int size = 101;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i=0;i<10;i++){
            executorService.execute(new WaitingTask(countDownLatch));
        }
        for (int i=0;i<size;i++){
            executorService.execute(new TaskPortion(countDownLatch));
        }
        System.out.println("launch all tasks");
        executorService.shutdown();
    }
}

class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch countDownLatch;

    public TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed");
    }

    @Override
    public String toString() {
        return String.format("%-5d", id);
    }
}

/**
 * 等待TaskPortion全部执行后再执行
 */
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch countDownLatch;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}