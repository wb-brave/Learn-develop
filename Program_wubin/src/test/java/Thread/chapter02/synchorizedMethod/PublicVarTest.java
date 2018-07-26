package Thread.chapter02.synchorizedMethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class PublicVarTest {

//    @Test
//    public void getValue() {
//    }
    public static void main(String[] wbs){

        PublicVar publicVar = new PublicVar();

        Thread thread = new Thread(){

            @Override
            public void run() {

                publicVar.setValue("B","BB");
            }
        };
        thread.setName("wubin");
        thread.start();
        try {
            thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        publicVar.getValue();

    }
}