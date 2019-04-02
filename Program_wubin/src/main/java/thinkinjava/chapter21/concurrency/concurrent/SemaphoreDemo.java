package thinkinjava.chapter21.concurrency.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.concurrent
 * @email wubin326@qq.com
 * @date 2019/01/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/23        wubin            0.0.1
 */
public class SemaphoreDemo {

    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new CheckOutTask<>(pool));
        }
        System.out.println("All CheckOutTasks created");
        List<Fat> list = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            Fat fat = pool.checkOut();
            System.out.println(i + " : main() thread check out ");
            fat.operation();
            list.add(fat);
        }
        Future<?> submit = executorService.submit(() -> {
            try {
                pool.checkOut();
            } catch (InterruptedException e) {
                System.out.println("check out interrupted");
            }
        });
        TimeUnit.SECONDS.sleep(2);
        submit.cancel(true);
        System.out.println("checking in objects in " + list);
        for (Fat fat : list) {
            pool.checkIn(fat);
        }
        for (Fat fat : list) {
            pool.checkIn(fat);//这次的checkin会被忽略
        }
        executorService.shutdown();
    }
}

class CheckOutTask<T> implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckOutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " check out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " check in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CheckOutTask{" +
                "id=" + id +
                '}';
    }
}