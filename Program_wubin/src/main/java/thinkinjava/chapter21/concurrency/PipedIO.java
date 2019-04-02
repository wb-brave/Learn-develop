package thinkinjava.chapter21.concurrency;

import java.io.*;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 使用管道进行线程通信(消费者与生产者的变体)
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class PipedIO {

    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
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

class Sender implements Runnable {

    private Random rand = new Random(47);
    private PipedWriter pw = new PipedWriter();

    public PipedWriter getPw() {
        return pw;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c < 'z'; c++) {
                    pw.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println(e + "Sender write exception!");
        } catch (InterruptedException e) {
            System.out.println(e + "Sender sleep interrupted!");
        }
    }
}

class Receiver implements Runnable{

    private PipedReader pr;

    public Receiver(Sender sender) throws IOException {
        pr = new PipedReader(sender.getPw());
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println("read: " + (char)pr.read() + " ");
            }
        } catch (IOException e) {
            System.out.println("Receiver read exception!");
        }
    }
}