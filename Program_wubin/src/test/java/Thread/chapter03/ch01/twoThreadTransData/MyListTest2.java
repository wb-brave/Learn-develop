package Thread.chapter03.ch01.twoThreadTransData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

public class MyListTest2 {

    public static void main(String[] wubin){
        Object object = new Object();

        MyList myList = new MyList();
        Thread thread = new Thread(()->{
            synchronized (object){
                System.out.println("当前线程 "+Thread.currentThread().getName()+" 时间 "+System.currentTimeMillis());
                try {
                    if (myList.getSize()!=5) {
                        object.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程 "+Thread.currentThread().getName()+" wait后时间 "+System.currentTimeMillis());
            }
        },"a");
        Thread thread2 = new Thread(()->{
            synchronized (object){

                for (int i=0;i<10;i++) {
                    myList.setData();
                    if (myList.getSize()==5) {
                        object.notifyAll();
                        System.out.println("当前线程 "+Thread.currentThread().getName()+" notify后时间 "+System.currentTimeMillis());
                    }
                    System.out.println("添加了 "+(i+1)+" 个元素");
                }
            }
        },"b");
        Thread thread3 = new Thread(()->{
            synchronized (object){
                System.out.println("当前线程 "+" 时间 "+System.currentTimeMillis());
                try {
                    if (myList.getSize()!=5) {
                        object.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程 "+Thread.currentThread().getName()+" wait后时间 "+System.currentTimeMillis());
            }
        },"c");
//        thread3.setPriority(10);
        thread.start();
        thread3.start();
        try {
            Thread.sleep(1);//线程沉睡后唤醒了所有等待的线程，因为会出现通知过早的意外情况
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread2.start();

//        HashMap<Thread,StackTraceElement[]> hashMap = (HashMap<Thread, StackTraceElement[]>) Thread.getAllStackTraces();
//        Iterator<Map.Entry<Thread,StackTraceElement[]>> iterator = hashMap.entrySet().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next().getKey()+" "+iterator.next().getValue());
//        }
    }
}