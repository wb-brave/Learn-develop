package thinkinjava.chapter21.concurrency.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            delayQueue.put(new DelayedTask(random.nextInt(5000)));
        }
        //设置停止得点
        delayQueue.add(new DelayedTask.EndSentinel(random.nextInt(5000),executorService));
        executorService.execute(new DelayTaskConsumer(delayQueue));
    }
}

class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delta) {
        this.delta = delta;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask delayedTask = (DelayedTask) o;
        return Long.compare(this.trigger, delayedTask.trigger);
    }

    @Override
    public void run() {
        System.out.print(this + " ");
    }

    @Override
    public String toString() {
        return String.format("[%-4d]", delta) + "task:" + id;
    }

    public String summary() {
        return "(" + id + " : " + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService executorService;

        public EndSentinel(int delta, ExecutorService executorService) {
            super(delta);
            this.executorService = executorService;
        }

        @Override
        public void run() {
            for (DelayedTask delayedTask : sequence) {
                System.out.print(delayedTask.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " calling shutdownNow()");
            executorService.shutdownNow();
        }
    }
}

class DelayTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> delayQueue;

    public DelayTaskConsumer(DelayQueue<DelayedTask> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                delayQueue.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished DelayTaskConsumer");
    }
}