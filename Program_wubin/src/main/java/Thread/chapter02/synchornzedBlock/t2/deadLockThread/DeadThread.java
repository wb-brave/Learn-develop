package Thread.chapter02.synchornzedBlock.t2.deadLockThread;

public class DeadThread implements Runnable{
    private String username;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                System.out.println("username = " + username);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2){
                    System.out.println("lock1-->lock2顺序执行");
                }
            }
        }
        if (username.equals("b")) {
            synchronized (lock2) {
                System.out.println("username = " + username);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1){
                    System.out.println("lock2-->lock1顺序执行");
                }
            }
        }
    }
}
