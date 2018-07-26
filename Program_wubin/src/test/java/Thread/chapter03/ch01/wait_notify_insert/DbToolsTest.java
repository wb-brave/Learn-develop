package Thread.chapter03.ch01.wait_notify_insert;

import static org.junit.Assert.*;

public class DbToolsTest {

    public static void main(String[] wb){
        DbTools dbTools = new DbTools();
        for (int i = 0;i<20;i++){
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    dbTools.backB();
                }
            });
            b.start();
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    dbTools.backA();
                }
            });
            a.start();
        }
    }
}