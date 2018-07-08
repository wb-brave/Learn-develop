package Thread.simple_thread;

public class IsAliveThread extends Thread{
    public IsAliveThread(){

        System.out.println("CurrentThreadComplex start");
        System.out.println("Thread.currentThread().getName() "+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() "+Thread.currentThread().isAlive());
        System.out.println("this.getName() "+this.getName());
        System.out.println("this.getName() "+this.isAlive());
        System.out.println("CurrentThreadComplex end");
    }

    @Override
    public void run() {
        System.out.println("run start");
        System.out.println("Thread.currentThread().getName() "+Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() "+Thread.currentThread().isAlive());
        System.out.println("this.getName() "+this.getName());
        System.out.println("this.getName() "+this.isAlive());
        System.out.println("run end ");
    }
}
