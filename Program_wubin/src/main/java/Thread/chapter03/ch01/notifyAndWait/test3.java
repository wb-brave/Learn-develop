package Thread.chapter03.ch01.notifyAndWait;

public class test3 {
    public static void main(String[] args){
        Object object = new Object();

        Thread thread = new Thread(()->{
            synchronized (object){
                System.out.println("当前线程 "+Thread.currentThread().getName()+" 时间 "+System.currentTimeMillis());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程 "+Thread.currentThread().getName()+" wait后时间 "+System.currentTimeMillis());
            }
        },"a");
        Thread thread2 = new Thread(()->{
            synchronized (object){
                System.out.println("当前线程 "+Thread.currentThread().getName()+" 时间 "+System.currentTimeMillis());
                object.notify();
                System.out.println("当前线程 "+Thread.currentThread().getName()+" notify后时间 "+System.currentTimeMillis());
            }
        },"b");
        thread.start();
        try {
//            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
