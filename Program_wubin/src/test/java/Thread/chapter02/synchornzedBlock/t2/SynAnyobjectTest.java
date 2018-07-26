package Thread.chapter02.synchornzedBlock.t2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SynAnyobjectTest {

//    @Test
//    public void run() {

    public static void main(String[] wubin){
        SynAnyobject synAnyobject = new SynAnyobject();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                synAnyobject.setProporty("a","aa");
            }
        });
        thread1.setName("a");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synAnyobject.setProporty("b","bb");
            }
        });
        thread2.setName("b");
        thread2.start();
    }
}