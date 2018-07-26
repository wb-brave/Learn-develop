package Thread.chapter07;

public class ThreadState extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run " + Thread.currentThread().getState());

    }
}
