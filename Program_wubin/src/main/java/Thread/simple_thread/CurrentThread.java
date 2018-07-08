package Thread.simple_thread;

public class CurrentThread extends Thread{
    public CurrentThread(){

        System.out.println("构造方法打印 "+Thread.currentThread().getName());
    }

    @Override
    public void run() {

        System.out.println("run方法打印 "+Thread.currentThread().getName());
    }
}
