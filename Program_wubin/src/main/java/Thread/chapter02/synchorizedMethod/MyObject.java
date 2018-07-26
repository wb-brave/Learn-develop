package Thread.chapter02.synchorizedMethod;

public class MyObject {
    synchronized public void method1(){

        try {

            System.out.println("Start A " + " " + Thread.currentThread().getName()+" end time "+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("A end time "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    public void method2(){
    synchronized public void method2(){

        try {

            System.out.println("Start B " + " end time  " + Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(5000);

            System.out.println("B end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
