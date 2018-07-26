package Thread.chapter02.synchornzedBlock.t2;

import static org.junit.Assert.*;

public class ChangeLockTest {

    public static void main(String[] wubin){
        ChangeLock changeLock = new ChangeLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"a");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"b");

        thread1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}