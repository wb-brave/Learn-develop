package Thread.chapter02.synchornzedBlock.t2;

public class MyThread2 extends Thread{
    private MyList myList;

    public MyThread2(MyList list){

        myList = list;
    }

    @Override
    public void run() {

        MyService myService = new MyService();
        myService.addServiceMethod(myList,"2");
    }
}
