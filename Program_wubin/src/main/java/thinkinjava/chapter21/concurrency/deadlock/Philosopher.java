package thinkinjava.chapter21.concurrency.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.deadlock
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class Philosopher implements Runnable{

    private Chopsticks left;
    private Chopsticks right;
    private final int id;
    private final int ponderfactor;
    private Random rand = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderfactor == 0){
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderfactor*250));
    }

    public Philosopher(Chopsticks left, Chopsticks right, int id, int ponderfactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderfactor = ponderfactor;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " got right");
                System.out.println(this + " grabbing left");
                left.take();
                // System.out.println(this + " got left");
                System.out.println(this + " eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupted");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
