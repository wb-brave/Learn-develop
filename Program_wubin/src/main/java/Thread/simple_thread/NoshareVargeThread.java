package Thread.simple_thread;

public class NoshareVargeThread extends Thread{
    private int count = 3;
    NoshareVargeThread(){

    }
    public NoshareVargeThread(String i){
        super();
        this.setName(i);
    }

    @Override
    synchronized public void run() {
        super.run();
        while (count>0){
            count--;
            System.out.println("由" + currentThread().getName() + "计算 " + count);
        }
    }
}
