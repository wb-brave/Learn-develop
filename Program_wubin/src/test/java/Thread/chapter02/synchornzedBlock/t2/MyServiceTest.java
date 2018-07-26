package Thread.chapter02.synchornzedBlock.t2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyServiceTest {

//    @Test
//    public void addServiceMethod() {
//    }
    public static void main(String[] wubin){
        MyList myList = new MyList();
        MyThread1 myThread1 = new MyThread1(myList);
        myThread1.setName("a");
        myThread1.start();
        MyThread2 myThread2 = new MyThread2(myList);
        myThread2.setName("b");
        myThread2.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("listsize " + myList.getSize());
    }
}