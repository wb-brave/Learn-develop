package Thread.chapter07;

public class ThreadGroupWb {
    public static void main(String[] wb){
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup threadGroup = new ThreadGroup(mainGroup,"w");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run method ");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(threadGroup,runnable);
        thread.setName("b");
        thread.start();

        ThreadGroup[] threadGroups = new ThreadGroup[1];
        System.out.println(Thread.currentThread().getThreadGroup().enumerate(threadGroups));
        System.out.println("main thread have count child thread " + threadGroups.length + " name " + threadGroups[0].getName());

        Thread[] threads = new Thread[threadGroups[0].activeCount()];
        System.out.println(threadGroups[0].enumerate(threads));
        System.out.println(threads[0].getName());


    }
}
