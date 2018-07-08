package Thread.stopAndResumeThread;

public class MyThread extends Thread {
    private long i = 0l;

    public void setI(long i) {
        this.i = i;
    }

    public long getI() {
        return i;
    }

    @Override
    public void run() {

        while (true){
            i++;
        }
    }
}
