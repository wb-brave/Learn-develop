package thinkinjava.chapter21.concurrency.deadlock;

import java.io.IOException;
import java.util.concurrent.*;

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
public class FixedDiningPhilosophers {

    public static void main(String[] args) throws InterruptedException, IOException {
        int pound = 5;
        if (args.length > 0) {
            pound = Integer.parseInt(args[0]);
        }
        int size = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopsticks[] chopsticks = new Chopsticks[5];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopsticks();
        }
        for (int i = 0; i < size; i++) {
            if (i<size-1){
                executorService.execute(new Philosopher(chopsticks[i],
                        chopsticks[(i + 1) % size], i, pound));
            }else {
                executorService.execute(new Philosopher(chopsticks[0],
                        chopsticks[i], i, pound));
            }
        }
        TimeUnit.SECONDS.sleep(5);
        // System.in.read();
        executorService.shutdownNow();
    }
}
