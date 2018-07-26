package Thread.chapter03.ch01.p_r_test;


public class Produce {
    private String lock;

    public Produce(String lock){
        this.lock = lock;
    }

    public void setValue(){
        synchronized (lock){
            try {
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                System.out.println("set value " + value);
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
