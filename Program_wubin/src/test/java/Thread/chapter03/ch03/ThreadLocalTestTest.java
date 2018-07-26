package Thread.chapter03.ch03;

import static org.junit.Assert.*;

public class ThreadLocalTestTest {

    public static void main(String[] wb){
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    ThreadLocalTest.threadLocal.set("a "+(i+1));
                    System.out.println("a getvalue "+ThreadLocalTest.threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threada.start();
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    ThreadLocalTest.threadLocal.set("b "+(i+1));
                    System.out.println("b getvalue "+ThreadLocalTest.threadLocal.get());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadb.start();
        for (int i=0;i<100;i++){
            ThreadLocalTest.threadLocal.set("main "+(i+1));
            System.out.println("main getvalue "+ThreadLocalTest.threadLocal.get());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}