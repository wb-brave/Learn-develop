package exercise;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2019/03/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/03/28        wubin            0.0.1
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        thread1.start();
        // thread1.join();
        thread2.start();
        // thread2.join();
        thread3.start();
    }
}

class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println(1);
        System.out.println(2);
    }
}

class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println(3);
        System.out.println(4);
    }
}
class Thread3 extends Thread {

    @Override
    public void run() {
        System.out.println(3);
        System.out.println(4);
    }
}