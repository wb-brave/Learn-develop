package Thread.chapter02.synchorizedMethod;

public class SycMethodThread2 extends Thread{

    private HasSelfPrivateNum hasSelfPrivateNum;

    public SycMethodThread2(HasSelfPrivateNum hasSelfPrivateNum){
        super();
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {

        hasSelfPrivateNum.add("b");
    }
}
