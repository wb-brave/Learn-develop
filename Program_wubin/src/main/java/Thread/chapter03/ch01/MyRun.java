package Thread.chapter03.ch01;

public class MyRun {
    private String lock = "wubin";
    private boolean flag = false;

    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag == false) {
                    System.out.println("begin wait ");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end wait ");
                }
            }
        }
    };
    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag==false){
                    System.out.println("begin noty ");
                    lock.notify();
                    flag = true;
                    System.out.println("end noty ");
                }
            }
        }
    };
    public static void main(String[] wubin){

        MyRun myRun = new MyRun();
        Thread t = new Thread(myRun.runnable1);
        Thread t1 = new Thread(myRun.runnable2);
        t.start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t1.start();
    }
}
