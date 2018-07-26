package Thread.chapter03.ch01.waitOld;

public class Sub {
    private String lock;
    public Sub(String lock){

        this.lock = lock;
    }
    public void remove(){

        synchronized (lock) {
            while (ValueObject.list.size()==0) {
                System.out.println("begin wait name "+Thread.currentThread().getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end wait name "+Thread.currentThread().getName());
            }
            ValueObject.list.remove(0);
            System.out.println("size "+ValueObject.list.size());
        }
    }
}
