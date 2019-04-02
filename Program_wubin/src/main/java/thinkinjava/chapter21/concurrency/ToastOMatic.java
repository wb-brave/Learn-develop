package thinkinjava.chapter21.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 生产者与消费者
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class ToastOMatic {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                butterQueue = new ToastQueue(),
                finishQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue,butterQueue));
        executorService.execute(new Jammer(butterQueue,finishQueue));
        executorService.execute(new Eater(finishQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Toast {
    public enum Status {
        DRY, BUTTERED, JAMMED
    }

    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = status.BUTTERED;
    }

    public void jammed() {
        status = status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
};

class Toaster implements Runnable {

    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(
                        100 + rand.nextInt(500)
                );
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Toaster interrupted");
        }
        System.out.println("toaster off");
    }
}

class Butterer implements Runnable {
    private ToastQueue dryQueue, butterQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butterQueue) {
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = dryQueue.take();
                take.butter();
                System.out.println(take);
                butterQueue.put(take);
            }
        } catch (InterruptedException e) {
            System.out.println("butter interrupted");
        }
        System.out.println("buffer off");
    }
}

class Jammer implements Runnable {
    private ToastQueue butterQueue, jammerQueue;

    public Jammer(ToastQueue butterQueue, ToastQueue jammerQueue) {
        this.butterQueue = butterQueue;
        this.jammerQueue = jammerQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = butterQueue.take();
                take.jammed();
                System.out.println(take);
                jammerQueue.add(take);
            }
        } catch (InterruptedException e) {
            System.out.println("jammer interrupted");
        }
        System.out.println("jammer is off");
    }
}

class Eater implements Runnable {
    private ToastQueue finishQueue;
    private int counter = 0;

    public Eater(ToastQueue finishQueue) {
        this.finishQueue = finishQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = finishQueue.take();
                if (take.getId() != counter++ || take.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>Error " + take);
                    System.exit(1);
                } else {
                    System.out.println("chomp! " + take);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted");
        }
        System.out.println("eater is off");
    }
}