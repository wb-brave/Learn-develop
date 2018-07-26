package Thread.chapter02.synchornzedBlock.t2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SynAnyobjectThisTest {

//    @Test
//    public void a() {
//    }
    public static void main(String[] wubin){
        SynAnyobjectThis synAnyobjectThis = new SynAnyobjectThis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synAnyobjectThis.a();
            }
        });
        thread1.setName("a");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synAnyobjectThis.b();
            }
        });
        thread2.setName("b");
        thread2.start();
    }
}