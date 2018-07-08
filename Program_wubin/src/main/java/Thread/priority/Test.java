package Thread.priority;

public class Test {
    public static void main(String[] args){
        /*
        优先级有继承性，若A启动B,则B与A是一样的  （重点：启动）
         */
        System.out.println("main run priority " + Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
        System.out.println("main run priority " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}

