package Thread.simple_thread;

public class CurrentThreadComplex extends Thread{
    public CurrentThreadComplex(){

        System.out.println("CurrentThreadComplex start");
        System.out.println("Thread.currentThread().getName() "+Thread.currentThread().getName());
        System.out.println("this.getName() "+this.getName());
        System.out.println("CurrentThreadComplex end");
    }

    @Override
    public void run() {
        System.out.println("run start");
        System.out.println("Thread.currentThread().getName() "+Thread.currentThread().getName());
        System.out.println("this.getName() "+this.getName());
        System.out.println("run end ");
    }
}
