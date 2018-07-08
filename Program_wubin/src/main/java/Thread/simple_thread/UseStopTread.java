package Thread.simple_thread;

public class UseStopTread extends Thread{
    private static int i = 0;

    @Override
    public void run() {

        try{

            while (true){
                System.out.println("i = "+ i + " " +Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("run catch");
            e.printStackTrace();
        }
    }
}
