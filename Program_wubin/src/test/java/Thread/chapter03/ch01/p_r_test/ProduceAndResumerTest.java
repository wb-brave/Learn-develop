package Thread.chapter03.ch01.p_r_test;


public class ProduceAndResumerTest {
    public static void main(String[] wubin){
        String wb = new String("");
        Produce produce = new Produce(wb);
        Resumer resumer = new Resumer(wb);
        ThreadA thread = new ThreadA(produce);
        ThreadB thread1 = new ThreadB(resumer);

        thread.start();
        thread1.start();
    }

}