package Thread.stopAndResumeThread;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyThreadTest {

    @Test
    public void run() {
       try {

           MyThread myThread = new MyThread();
           myThread.start();
           Thread.sleep(5000);

           myThread.suspend();
           System.out.println("A= " + System.currentTimeMillis() + " i= " + myThread.getI());
           Thread.sleep(5000);
           System.out.println("A= " + System.currentTimeMillis() + " i= " + myThread.getI());

           myThread.resume();
           Thread.sleep(5000);

           myThread.suspend();
           System.out.println("B= " + System.currentTimeMillis() + " i= " + myThread.getI());
           Thread.sleep(5000);
           System.out.println("B= " + System.currentTimeMillis() + " i= " + myThread.getI());
       }catch (InterruptedException e){
           e.printStackTrace();
       }


    }
}