package Thread.chapter04.condition123;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Run {
    private static ReentrantLock lock =new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();
    public static void main(String[] wb){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();
                try {
                    while (F.nextPrintWho!=1){
                        condition1.await();
                    }
                    for (int i=0;i<3;i++){
                        System.out.println("thread1 " + (i+1));
                    }
                    F.nextPrintWho=2;
                    condition2.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();
                try {
                    while (F.nextPrintWho!=2){
                        condition1.await();
                    }
                    for (int i=0;i<3;i++){
                        System.out.println("thread2 " + (i+1));
                    }
                    F.nextPrintWho=3;
                    condition3.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                lock.lock();
                try {
                    while (F.nextPrintWho!=3){
                        condition1.await();
                    }
                    for (int i=0;i<3;i++){
                        System.out.println("thread3 " + (i+1));
                    }
                    F.nextPrintWho=1;
                    condition1.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread[] thread1s = new Thread[5];
        Thread[] thread2s = new Thread[5];
        Thread[] thread3s = new Thread[5];

        for (int i=0;i<5;i++){
            thread1s[i] = new Thread(thread1);
            thread2s[i] = new Thread(thread2);
            thread3s[i] = new Thread(thread3);

            thread1s[i].start();
            thread2s[i].start();
            thread3s[i].start();
        }
    }
}
