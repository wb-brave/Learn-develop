package thinkinjava.chapter21.concurrency.waxomatic;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.waxomatic
 * @email wubin326@qq.com
 * @date 2019/01/09
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/09        wubin            0.0.1
 */
public class WaxOMatic1 {

    public static void main(String[] args) throws InterruptedException {
        Car1 car = new Car1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOff1(car));
        executorService.execute(new WaxOn1(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Car1 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            // notifyAll();
            condition.signalAll();
        }finally {
            //放在finally语句块中，确保能够释放锁
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            // notifyAll();
            condition.signalAll();
        }finally {
            //放在finally语句块中，确保能够释放锁
            lock.unlock();
        }
    }

    public void waitingForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false) {
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void waitingForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true) {
                condition.await();
            }
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn1 implements Runnable {

    private Car1 car;

    public WaxOn1(Car1 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("exit via interrupt");
        }
        System.out.println("Ending wax on task");
    }
}

class WaxOff1 implements Runnable {

    private Car1 car;

    public WaxOff1(Car1 car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("exit via interrupt");
        }
        System.out.println("Ending wax off task");
    }
}