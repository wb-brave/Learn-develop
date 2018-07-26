package Thread.chapter04.useConditionWaitNotifyOk;

import static org.junit.Assert.*;

public class MyServiceTest {

    public static void main(String[] wb){
        MyService myService = new MyService();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.aWait();
            }
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myService.signal();
    }
}