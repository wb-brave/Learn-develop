package thinkinjava.chapter21.concurrency.exercise;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.exercise
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class Exer6 implements Runnable{

    private Random rand = new Random();
    @Override
    public void run() {
        int i = rand.nextInt(10);
        System.out.println("sleeping " + i);
        try {
            TimeUnit.MILLISECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int i = 6;
        while (i-->0){
            executorService.execute(new Exer6());
        }
        executorService.shutdown();
    }
}
