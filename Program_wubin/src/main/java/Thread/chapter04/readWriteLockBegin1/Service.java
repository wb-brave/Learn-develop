package Thread.chapter04.readWriteLockBegin1;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read(){
        try {

            try {
                lock.readLock().lock();
                System.out.println("获得锁 "+Thread.currentThread().getName()+" " +System.currentTimeMillis());
                Thread.sleep(10000);
            }finally {
                lock.readLock().unlock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //读写互斥
    public void write(){
        try {

            try {
                lock.writeLock().lock();
                System.out.println("获得锁 "+Thread.currentThread().getName()+" " +System.currentTimeMillis());
                Thread.sleep(10000);
            }finally {
                lock.writeLock().unlock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
