package Thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Testctwl {

    public static void main(String[] wb){
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(){
            @Override
            public void run() {
                System.out.println("1 进入");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("2 进入");
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }.start();

        System.out.println("================");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("+++++++++++++");
    }
}
