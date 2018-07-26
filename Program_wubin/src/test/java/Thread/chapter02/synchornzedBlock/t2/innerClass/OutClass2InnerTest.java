package Thread.chapter02.synchornzedBlock.t2.innerClass;

import static org.junit.Assert.*;

public class OutClass2InnerTest {

    public static void main(String[] wubin){

        final OutClass2Inner.Inner1 inner1 = new OutClass2Inner.Inner1();
        final OutClass2Inner.Inner2 inner2 = new OutClass2Inner.Inner2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner1.method1(inner2);
            }
        },"a");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner1.method2();
            }
        },"b");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner2.method1();
            }
        },"c");

        t1.start();
        t2.start();
        t3.start();
    }
}