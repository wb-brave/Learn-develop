package Thread.chapter04.p_r_test_1_1_codition;


public class MyServiceTest {

    public static void main(String[] wu) {
        MyService myService = new MyService();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.set();
            }
        });
        thread.start();

        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.get();
            }
        });
        threada.start();
    }

}