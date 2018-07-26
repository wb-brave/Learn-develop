package Thread.chapter02.volatile3;

public class PrintString implements Runnable {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean flag(){
        return flag;
    }

    public void m(){
        while (flag){
            System.out.println("run m threadname " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        m();
    }
}
