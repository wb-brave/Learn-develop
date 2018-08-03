package Thread.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Testcb {
    public static void main(String[] wb) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("last excute");
            }
        });
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println("i am " + Thread.currentThread().getName());
                    try {
                        cyclicBarrier.await();
                        System.out.println("我们要一起吃饭");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
