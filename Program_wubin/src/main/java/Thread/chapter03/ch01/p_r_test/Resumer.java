package Thread.chapter03.ch01.p_r_test;


public class Resumer {
    private String lock;

    public Resumer(String lock){
        this.lock = lock;
    }

    public void resumeValue(){
        synchronized (lock){
            try {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("resume value " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
