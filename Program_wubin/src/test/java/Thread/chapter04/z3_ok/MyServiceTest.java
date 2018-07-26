package Thread.chapter04.z3_ok;


public class MyServiceTest {

    public static void main(String[] wb){
        MyService myService = new MyService();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.aWait();
            }
        });
        thread.start();
    }
}