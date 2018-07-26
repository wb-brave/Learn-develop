package Thread.chapter02.synchornzedBlock.t2.deadLockThread;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeadThreadTest {

//    @Test
//    public void run() {
//    }
    public static void main(String[] wubin){
        DeadThread deadThread1 = new DeadThread();
        deadThread1.setUsername("a");
        Thread thread1 = new Thread(deadThread1);
        thread1.setName("a");
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        deadThread1.setUsername("b");
        Thread thread2 = new Thread(deadThread1);
        thread2.start();
    }
}