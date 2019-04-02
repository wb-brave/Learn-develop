package thinkinjava.chapter21.concurrency;

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
public class Restaurant {
    Meal meal;
    ExecutorService exe = Executors.newCachedThreadPool();
    Waiter waiter = new Waiter(this);
    Chef chef = new Chef(this);
    BusBoy busBoy = new BusBoy(this);

    public Restaurant() {
        exe.execute(chef);
        exe.execute(waiter);
        exe.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;

    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

class Waiter implements Runnable {

    private Restaurant restaurant;
    public boolean clean = true;
    public Meal m;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {

            /**
             * 如果没有被中断
             */
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("waiter got " + (m = restaurant.meal));
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                synchronized (restaurant.busBoy) {
                    // while (restaurant.waiter.clean) {
                        clean = false;
                        restaurant.busBoy.notifyAll();
                    // }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("waiter is interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("out of food! closing");
                    restaurant.exe.shutdownNow();
                    return;
                }
                System.out.print("order up! ");
                synchronized (restaurant.waiter) {
                    restaurant.meal = new Meal(count);
                    restaurant.waiter.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("chef is interrupted");
        }
    }
}

class BusBoy implements Runnable {

    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.waiter.clean) {
                        wait();
                    }
                    System.out.println("cleaning " + restaurant.waiter.m);
                    restaurant.waiter.clean = true;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("busBoy is interrupted");
        }
    }
}