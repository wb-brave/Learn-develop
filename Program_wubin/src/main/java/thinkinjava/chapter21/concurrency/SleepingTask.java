package thinkinjava.chapter21.concurrency;

import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class SleepingTask extends LiftOff {

    @Override
    public void run() {
        while (count-- > 0) {
            status();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int i = 0;
        while (i++ < 5) {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
}
