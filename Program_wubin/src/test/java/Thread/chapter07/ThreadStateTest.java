package Thread.chapter07;

import static org.junit.Assert.*;

public class ThreadStateTest {

    public static void main(String[] wb) {
        System.out.println("main " + Thread.currentThread().getState());
        ThreadState threadState = new ThreadState();
        threadState.setName("run");
        System.out.println("run " + threadState.getState());
        threadState.start();
        System.out.println("run " + threadState.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main " + Thread.currentThread().getState());
    }
}