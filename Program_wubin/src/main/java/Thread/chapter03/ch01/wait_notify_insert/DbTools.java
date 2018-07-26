package Thread.chapter03.ch01.wait_notify_insert;

public class DbTools {
    private volatile boolean previsA = false;
    synchronized public void backA(){
        try {
            while (previsA == true){
                wait();
            }
            for (int i=0;i<5;i++){
                System.out.println("*************");
            }
            previsA = true;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    synchronized public void backB(){
        try {
            while (previsA == false){
                wait();
            }
            for (int i=0;i<5;i++){
                System.out.println("############");
            }
            previsA = false;
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
