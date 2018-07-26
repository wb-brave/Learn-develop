package Thread.chapter03.ch01.p_r_test;

public class ThreadB extends Thread{
    private Resumer resumer;
    public ThreadB(Resumer resumer){
        this.resumer = resumer;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            resumer.resumeValue();
        }
    }
}
