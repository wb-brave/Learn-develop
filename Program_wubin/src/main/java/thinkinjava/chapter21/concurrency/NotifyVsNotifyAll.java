package thinkinjava.chapter21.concurrency;

import java.util.Timer;
import java.util.TimerTask;
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
public class NotifyVsNotifyAll {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executorService.execute(new Task());
        }
        executorService.execute(new Task1());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod){
                    System.out.println("notify() ");
                    Task.blocker.prod();
                    prod = false;
                }else {
                    System.out.println("notifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("Timer is canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task1 blocker.prodAll() ");
        Task1.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shutting down");
        executorService.shutdownNow();
    }
}

class Blocker{
    synchronized void waitingCall(){
        try {
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via interrupt");
        }
    }
    synchronized void prod(){
        notify();
    }
    synchronized void prodAll(){
        notifyAll();
    }
}

class Task implements Runnable{
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
class Task1 implements Runnable{
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
