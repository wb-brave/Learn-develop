package Thread.simple_thread;

public class StopThreadByReturn extends Thread{
    @Override
    public void run() {

        while (true){
            if (this.isInterrupted()) {
                System.out.println("out");
                return;
            }
            System.out.println("time " + System.currentTimeMillis());
        }
    }
}
