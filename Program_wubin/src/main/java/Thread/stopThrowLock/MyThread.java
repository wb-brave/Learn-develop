package Thread.stopThrowLock;


public class MyThread extends Thread {

    private SynchronizedObject synchronizedObject;

    public MyThread(SynchronizedObject object){
        this.synchronizedObject = object;
    }
    @Override
    public void run() {
        synchronizedObject.print("b","bb");
    }
}
