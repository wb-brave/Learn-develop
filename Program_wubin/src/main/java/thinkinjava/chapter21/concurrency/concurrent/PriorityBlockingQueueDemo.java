package thinkinjava.chapter21.concurrency.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 这个实例有问题，应该队列一边读取一边添加，并不能保证以后的优先级比之前的就一定低
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/23        wubin            0.0.1
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> runnables = new PriorityBlockingQueue<>();
        executorService.execute(new PrioritizedTaskProducer(runnables, executorService));
        executorService.execute(new PrioritizedTaskConsumer(runnables));
    }
}

class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        /**
         * 记录每个任务创建的顺序
         */
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Long.compare(o.priority, this.priority);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", priority) + " task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService executorService;

        public EndSentinel(ExecutorService executorService) {
            //设置为最小的优先级
            super(-1);
            this.executorService = executorService;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask prioritizedTask : sequence) {
                System.out.println(prioritizedTask.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
            }

        }
    }
}

class PrioritizedTaskProducer implements Runnable {

    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService executorService;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService executorService) {
        this.queue = queue;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(i));
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(i));
            }
            //停止所有的任务
            queue.add(new PrioritizedTask.EndSentinel(executorService));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished priorityTask");
    }
}

class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //    使用当前线程执行任务
                queue.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished prioritizedTaskConsumer");
    }
}