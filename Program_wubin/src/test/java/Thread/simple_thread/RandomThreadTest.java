package Thread.simple_thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomThreadTest {

    @Test
    public void run() {
        RandomThread randomThread = new RandomThread();
        randomThread.setName("wubin");
        randomThread.start();
        for (int i = 0; i < 10; i++){
            int time = (int) Math.random() * 1000;
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run="+Thread.currentThread().getName());
        }
    }
}