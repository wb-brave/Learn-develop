package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoshareVargeThreadTest {

    @Test
    public void run() {
        /*
        不共享变量
         */
//        NoshareVargeThread thread1 = new NoshareVargeThread("a");
//        NoshareVargeThread thread2 = new NoshareVargeThread("b");
//        NoshareVargeThread thread3 = new NoshareVargeThread("c");
//        thread1.start();
//        thread2.start();
//        thread3.start();
        /*
        共享变量
         */
        NoshareVargeThread thread = new NoshareVargeThread();
        Thread thread1 = new Thread(thread,"a");
        Thread thread2 = new Thread(thread,"b");
        Thread thread3 = new Thread(thread,"c");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}