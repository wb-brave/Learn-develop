package Thread.chapter04.p_r_test_1_1_codition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyServiceMore {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        lock.lock();
        try {
            while (hasValue == true){
                System.out.println("有可能***连续");
                condition.await();
            }
            System.out.println("println **********");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try {
            while (hasValue == false){
                System.out.println("有可能###连续");
                condition.await();
            }
            System.out.println("print ##########");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
