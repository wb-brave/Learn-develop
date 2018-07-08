package Thread.stopAndResumeThread;

public class SynchronizedObject {

    synchronized public void printString(){

       System.out.println("Begin ");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("被线程a永远停止");
            Thread.currentThread().suspend();
        }
        System.out.println("end");

    }
}
