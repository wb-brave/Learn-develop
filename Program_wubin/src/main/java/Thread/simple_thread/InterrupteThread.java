package Thread.simple_thread;

public class InterrupteThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 50000; i++){
            System.out.println("i = "+(i+1));
        }
    }
}
