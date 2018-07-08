package Thread.stopThrowLock;

import Thread.safeThread.ALogin;
import Thread.safeThread.BLogin;

public class run {
    public static void main(String[] args){
       try {

           SynchronizedObject object = new SynchronizedObject();
           MyThread myThread = new MyThread(object);
           myThread.start();
           Thread.sleep(500);
           myThread.stop();
           System.out.println(object.getUsername() + " " + object.getPassword());
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }

}
