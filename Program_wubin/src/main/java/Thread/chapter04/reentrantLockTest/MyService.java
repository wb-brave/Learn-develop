package Thread.chapter04.reentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public void foo(){
        lock.lock();
        for (int i=0;i<5;i++){
            System.out.println("name "+Thread.currentThread().getName()+(" "+(i+1)));
        }
        lock.unlock();
    }
}
