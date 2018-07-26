package Thread.chapter03.ch01.notifyAndWait;

public class test1 {
    public static void main(String[] args){
        String a = "asd";
        try {
            a.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
