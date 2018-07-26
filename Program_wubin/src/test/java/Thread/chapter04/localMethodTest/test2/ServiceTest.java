package Thread.chapter04.localMethodTest.test2;

import static org.junit.Assert.*;

public class ServiceTest {

    public static void main(String[] qb) {
        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.awaitS();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        service.notifyS();
    }
}