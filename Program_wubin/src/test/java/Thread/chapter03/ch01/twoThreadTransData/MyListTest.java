package Thread.chapter03.ch01.twoThreadTransData;


public class MyListTest {

    public static void main(String[] args){
        MyList myList = new MyList();

        ThreadA thread = new ThreadA(myList);
        thread.setName("a");
        ThreadB thread1 = new ThreadB(myList);
        thread1.setName("b");

        thread1.start();
        thread.start();
    }

}