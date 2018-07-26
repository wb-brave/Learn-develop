package Thread.chapter03.ch01.p_r_test;

public class ThreadA extends Thread{
    private Produce produce;
    public ThreadA(Produce produce){
        this.produce = produce;
    }
    @Override
    public void run() {
        super.run();
        while (true){
            produce.setValue();
        }
    }
}
