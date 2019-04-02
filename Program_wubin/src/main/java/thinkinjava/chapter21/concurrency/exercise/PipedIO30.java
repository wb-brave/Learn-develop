package thinkinjava.chapter21.concurrency.exercise;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.exercise
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class PipedIO30 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Character> linkedBlockingQueue = new LinkedBlockingQueue<>();
        Sender1 sender = new Sender1(linkedBlockingQueue);
        Receiver1 receiver = new Receiver1(linkedBlockingQueue);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        /**
         * 这里调用线程中断的操作
         */
        executorService.shutdownNow();
    }
}

class Sender1 implements Runnable{

    private LinkedBlockingQueue<Character> pipeQueue;
    private Random rand = new Random(47);
    public Sender1(LinkedBlockingQueue pipeQueue) {
        this.pipeQueue = pipeQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c < 'z'; c++) {
                    pipeQueue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + "Sender sleep interrupted!");
        }
    }
}


class Receiver1 implements Runnable{
    private LinkedBlockingQueue<Character> pipeQueue;

    public Receiver1(LinkedBlockingQueue<Character> pipeQueue) {
        this.pipeQueue = pipeQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println("read: " + pipeQueue.take() + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}