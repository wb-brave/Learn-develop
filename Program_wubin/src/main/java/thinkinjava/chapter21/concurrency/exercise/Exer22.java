package thinkinjava.chapter21.concurrency.exercise;

import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.exercise
 * @email wubin326@qq.com
 * @date 2019/01/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/21        wubin            0.0.1
 */
public class Exer22 {
    public static void main(String[] args) {
        boolean flag = false;
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new FirstTask(flag));
        executorService.execute(new SecondTask(flag));
    }

}

class FirstTask implements Runnable {

    private volatile boolean flag;

    public FirstTask(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            flag = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondTask implements Runnable {
    private volatile boolean flag;

    public SecondTask(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            flag = false;
            System.out.println("change the flag!");
        }
    }
}