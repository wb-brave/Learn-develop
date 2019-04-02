package thinkinjava.chapter21.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author wubin
 * @Description 当程序运行的时候，如果没有非后台进程，程序会终止并kill所有的后台进程
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemons());
            /**
             * 不加这这个属性，线程将陷入无限循环
             */
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All daemons started");
        // TimeUnit.MILLISECONDS.sleep(1000);
    }
}
