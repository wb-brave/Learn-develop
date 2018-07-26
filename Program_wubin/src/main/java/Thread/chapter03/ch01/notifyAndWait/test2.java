package Thread.chapter03.ch01.notifyAndWait;

public class test2 {
    public static void main(String[] args){
        String a = "asd";
        System.out.println(1);
        synchronized (a){
            System.out.println(2);
            try {
                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }
        System.out.println(4);
    }
}
