package Thread.chapter04.localMethodTest.test1;

import java.util.concurrent.locks.ReentrantLock;

public class Service {
    private ReentrantLock lock = new ReentrantLock();
    public void method1(){
        try {
            lock.lock();
            System.out.println("method1 getholdcount "+ lock.getHoldCount());
            method2();
        }finally {
            lock.unlock();
        }
    }
    public void method2(){
        try {
            lock.lock();
            System.out.println("method2 getholdcount "+ lock.getHoldCount());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
