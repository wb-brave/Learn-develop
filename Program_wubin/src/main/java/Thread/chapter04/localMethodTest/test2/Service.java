package Thread.chapter04.localMethodTest.test2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void awaitS() {
        try {
            lock.lock();
//            System.out.println("method1 getholdcount "+ lock.getHoldCount());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyS() {
        try {
            lock.lock();
            System.out.println("有 " + lock.getWaitQueueLength(condition) + "等待");
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
