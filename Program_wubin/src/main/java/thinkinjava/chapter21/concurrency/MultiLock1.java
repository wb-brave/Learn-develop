package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description 同一个任务多次获得锁
 * 方法锁某种意义上等价于对象锁，当你使用synchronize修饰方法时，会自动获取这个类的对象进行加锁
 * 类锁指的是对于字节码的class进行加锁(通过对static关键字加锁或classname.class加锁)
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/08
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/08        wubin            0.0.1
 */
public class MultiLock1 {
    private static volatile int i = 0;
    public void f1(int count) {
        synchronized (MultiLock1.class){
            if (count-- > 0) {
                System.out.println("f1() calling f2() with count " + count);
                f2(count);
            }
        }
    }

    public void f2(int count) {
        synchronized (MultiLock1.class){
            if (count-- > 0) {
                System.out.println("f2() calling f1() with count " + count);
                f1(count);
            }
        }
    }

    public static void main(String[] args) {
        final MultiLock1 multiLock = new MultiLock1();
        new Thread(() -> multiLock.f1(10)).start();
    }
}
