package Thread.stopAndResumeThread;

import org.junit.Test;

import static org.junit.Assert.*;

public class SynchronizedObjectTest{

    @Test
    public void run() throws InterruptedException{

        final SynchronizedObject object = new SynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                object.printString();
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread.sleep(1000);

//        thread1.resume(); 如果加上这句就可以解决同步锁
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("B线程进入不到printString方法，因为被a占有 并被永远停止");
                object.printString();
            }
        };
        thread2.setName("b");
        thread2.start();
    }
}