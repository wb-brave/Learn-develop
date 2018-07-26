package Thread.chapter04.reentrantLockTest;

import static org.junit.Assert.*;

public class MyServiceTest {

    public static void main(String[] wb){

        MyService myService = new MyService();
        for (int i=0;i<5;i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.foo();
                }
            });
            thread.start();
        }
    }
}