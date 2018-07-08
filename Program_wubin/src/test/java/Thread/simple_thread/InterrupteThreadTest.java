package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterrupteThreadTest {

    @Test
    public void run() {
//        InterrupteThread interrupteThread = new InterrupteThread();
//        interrupteThread.start();
//        interrupteThread.interrupt();
//        /*
//            测试线程interrupteThread的状态
//         */
//        System.out.println("2 "+interrupteThread.isInterrupted());
//        System.out.println("1 "+interrupteThread.isInterrupted());
//
//        /*
//            测试当前线程--运行改方法的，的状态
//         */
//        System.out.println("2 "+interrupteThread.interrupted());
//        System.out.println("1 "+interrupteThread.interrupted());

        /*
            测试当前线程--运行改方法的，的状态，该静态方法具有清除线程状态的的功能（调用过后清除）
         */
        Thread.currentThread().interrupt();
        System.out.println("2 "+Thread.interrupted());
        System.out.println("1 "+Thread.interrupted());
    }
}