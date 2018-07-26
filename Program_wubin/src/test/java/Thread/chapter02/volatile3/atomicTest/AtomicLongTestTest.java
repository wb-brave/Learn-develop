package Thread.chapter02.volatile3.atomicTest;

import static org.junit.Assert.*;

public class AtomicLongTestTest {

    public static void main(String[] wubin){
        AtomicLongTest atomicLongTest = new AtomicLongTest();
        for (int i=0;i<5;i++){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    atomicLongTest.addNum();
                }
            };
//            Thread thread1 = new Thread(()->{atomicLongTest.addNum();});
            thread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(AtomicLongTest.atomicLong.get());
    }
}