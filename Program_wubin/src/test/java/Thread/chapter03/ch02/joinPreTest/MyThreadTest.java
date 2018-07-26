package Thread.chapter03.ch02.joinPreTest;

import static org.junit.Assert.*;

public class MyThreadTest {

    public static void main(String[] wv){
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            myThread.join(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("mythread执行完我再执行，加入join");
    }
}