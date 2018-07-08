package Thread.simple_thread;

public class InterrupteExceptionThread extends Thread {

    @Override
    public void run() {

        try {
            for (int i = 0; i < 500000; i++){
                if (this.isInterrupted()){
                    System.out.println("我要退出了");

                    throw new InterruptedException();
                }
                System.out.println("i = "+(i+1));
            }
            /*
            在异常范围之内时，终端后的代码不执行
             */
            System.out.println("我在for方法后面");
        } catch (Exception e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        System.out.println("我在exception范围之外");

    }
}
