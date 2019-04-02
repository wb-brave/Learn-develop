package thinkinjava.chapter21.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author wubin
 * @Description 检查中断，以及中断的惯用方法
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/08
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/08        wubin            0.0.1
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked3());
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();
    }
}

class NeedsCleanUp {
    private final int id;

    public NeedsCleanUp(int id) {
        this.id = id;
        System.out.println("NeedsCleanUp " + id);
    }

    public void cleanup() {
        System.out.println("clean up " + id);
    }
}

class Blocked3 implements Runnable {

    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //    point1
                NeedsCleanUp cleanUp1 = new NeedsCleanUp(1);
                /**
                 * 在定义cleanup1之后立即调用try finally 来保证正确的清理cleanup1
                 */
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //    point2
                    NeedsCleanUp cleanUp2 = new NeedsCleanUp(2);
                    try {
                        System.out.println("calculating");
                        //进行比较耗时间的运算，模拟程序运行耗时
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.E * Math.PI) / d * d;
                        }
                        System.out.println("finished time-consuming operation");
                    } finally {
                        cleanUp2.cleanup();
                    }
                } finally {
                    cleanUp1.cleanup();
                }
            }
            System.out.println("existing while test!");
        } catch (InterruptedException e) {
            System.out.println("exiting from InterruptedException");
        }
    }
}