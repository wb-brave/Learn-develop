package Thread.chapter02.synchornzedBlock.t2;

public class MyThread1 extends Thread{
    private MyList myList;

    public MyThread1(MyList list){

        myList = list;
    }

    @Override
    public void run() {

        MyService myService = new MyService();
        myService.addServiceMethod(myList,"1");
    }
}
