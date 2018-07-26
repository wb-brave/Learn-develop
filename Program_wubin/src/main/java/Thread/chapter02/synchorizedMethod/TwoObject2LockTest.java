package Thread.chapter02.synchorizedMethod;

public class TwoObject2LockTest {
    //使用 Thread.sleep()时，使用自动生成测试类调试有问题，
    public static void main(String[] args){
        HasSelfPrivateNum hasSelfPrivateNum  = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum1  = new HasSelfPrivateNum();
        SycMethodThread1 thread1 = new SycMethodThread1(hasSelfPrivateNum);
        thread1.start();
        SycMethodThread2 thread2 = new SycMethodThread2(hasSelfPrivateNum1);
        thread2.start();
    }
}
