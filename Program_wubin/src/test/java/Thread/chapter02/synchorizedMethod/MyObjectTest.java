package Thread.chapter02.synchorizedMethod;

import Thread.stopAndResumeThread.MyThread;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyObjectTest {

//    @Test
//使用 Thread.sleep()时，使用自动生成测试类调试有问题，
    public static void main(String[] args) {

        MyObject myObject = new MyObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                myObject.method1();
            }
        };
        thread1.setName("A");
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                myObject.method2();
            }
        };
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}