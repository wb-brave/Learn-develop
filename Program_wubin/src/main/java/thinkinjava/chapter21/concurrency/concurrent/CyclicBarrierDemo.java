package thinkinjava.chapter21.concurrency.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 使用与你希望创建一组任务，它们并行的执行任务，然后在进行下一个步骤之前等待
 * 直到所有任务都完成，与count...只触发一次比这个可以多次触发
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1                 利用CyclicBarrier模拟赛马
 */
public class CyclicBarrierDemo {

    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierDemo(int nHorses, final int pause) {
        /**
         * 构造这个类的时候指定一个匿名线程类 A
         * 但所有的任务都在等待的时候
         * cyclicBarrier唤醒所有的等待线程
         * 每个线程活动的时候都会执行这个 A
         */
        cyclicBarrier = new CyclicBarrier(nHorses, () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < FINISH_LINE; i++) {
                sb.append("=");
            }
            System.out.println(sb);
            /**
             * 每个线程任务的run方法里面都是会改变tracks的
             * 所以每次被执行获得到的值都是不同的
             */
            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }
            for (Horse horse : horses) {
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + " won!!!");
                    executorService.shutdownNow();
                    return;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("barrier-action sleep interrupted");
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHourses = 7;
        int pause = 200;
        new CyclicBarrierDemo(nHourses,pause);
    }
}

class Horse implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier cyclicBarrier;

    public Horse(CyclicBarrier cyclicBarrier1) {
        cyclicBarrier = cyclicBarrier1;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }

    public String tracks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }
}