package Thread.chapter04.localMethodTest.test3;

import static org.junit.Assert.*;

public class ServiceTest {
    public static void main(String[] strings) throws Exception{

        Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.awaitS();
            }
        };
        Thread threada = new Thread(runnable);
        threada.setName("A");
        threada.start();
        Thread.sleep(500);

        Thread threadb = new Thread(runnable);
        threadb.setName("B");
        threadb.start();
        threadb.interrupt();
        System.out.println("main end");
    }

}