package Thread.chapter03.ch02.joinPreTest;

public class MyThread extends Thread{
    @Override
    public void run() {

        int waitTime = (int)(Math.random()*10000);
        System.out.println(waitTime);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
