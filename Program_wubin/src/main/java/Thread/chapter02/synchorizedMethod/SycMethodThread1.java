package Thread.chapter02.synchorizedMethod;

public class SycMethodThread1 extends Thread{

    private HasSelfPrivateNum hasSelfPrivateNum;

    public SycMethodThread1(HasSelfPrivateNum hasSelfPrivateNum){
        super();
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {

        hasSelfPrivateNum.add("a");
    }
}
