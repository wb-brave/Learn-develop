package Thread.chapter03.ch01.twoThreadTransData;

public class ThreadB extends Thread {

    private MyList myList;

    public ThreadB(MyList list){
        this.myList = list;
    }

    @Override
    public void run() {
        try {
            while (true){
                if (myList.getSize() > 5) {
                    System.out.println("准备退出  ");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
