package Thread.chapter02.synchornzedBlock.t2.innerClass;

import static org.junit.Assert.*;

public class OutClassTest {

    public static void main(String[] wubin){

        final OutClass.Inner inner = new OutClass.Inner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        },"a");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        },"b");
        thread1.start();
        thread2.start();
    }

}