package Thread.chapter03.ch01.waitOld;

import static org.junit.Assert.*;

public class SubTest {

    public static void main(String[] wb){
        String lock = new String();
        Add add = new Add(lock);
        Sub sub = new Sub(lock);
        Thread thread = new Thread(()->{
            add.add();
        },"a");
        Thread thread1 = new Thread(()->{
            sub.remove();
        },"b");
        thread1.start();
        Thread thread2 = new Thread(()->{
            sub.remove();
        },"c");
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
}