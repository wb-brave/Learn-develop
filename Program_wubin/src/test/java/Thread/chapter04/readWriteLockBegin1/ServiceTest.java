package Thread.chapter04.readWriteLockBegin1;

import static org.junit.Assert.*;

public class ServiceTest {
    public static void main(String[] strings){
        Service service=new Service();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        });
        thread.setName("a");
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        });
        thread1.setName("b");
        thread1.start();
    }

}