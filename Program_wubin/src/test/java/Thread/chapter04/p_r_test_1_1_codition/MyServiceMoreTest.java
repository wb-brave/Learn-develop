package Thread.chapter04.p_r_test_1_1_codition;


public class MyServiceMoreTest {

    public static void main(String[] wb){
        MyServiceMore myService = new MyServiceMore();
        Thread[] threadas = new Thread[10];
        Thread[] threadbs = new Thread[10];
        for (int i=0;i<10;i++) {
            threadas[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.set();
                }
            });


            threadbs[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.get();
                }
            });
            threadbs[i].start();
            threadas[i].start();
        }
    }
}