package Thread.chapter04.useConditionWaitNotifyOk;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void aWait(){
        try {
            lock.lock();
            System.out.println("await time " + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("signal time " + System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }


}
