package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/07        wubin            0.0.1
 */
public class SyncObject {
    public static void main(String[] args) {
        DualSynch dualSynch = new DualSynch();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dualSynch.f();
            }
        }).start();
        dualSynch.g();
    }
}

class DualSynch {
    private Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}