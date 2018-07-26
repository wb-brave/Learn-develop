package Thread.chapter02.synchornzedBlock.t2;

public class ChangeLock {
    private String lock = "123";
    public void method(){
        String name = Thread.currentThread().getName();
        synchronized (lock){
            System.out.println(name + " begin " + System.currentTimeMillis());
            lock = "456";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " end " + System.currentTimeMillis());
        }
    }
}
