package Thread.chapter03.ch01.twoThreadTransData;

public class ThreadA extends Thread {

    private MyList myList;

    public ThreadA(MyList list){
        this.myList = list;
    }

    @Override
    public void run() {

        try {
            for (int i=0;i<10;i++) {
                myList.setData();
                System.out.println("添加了 "+(i+1)+" 个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
