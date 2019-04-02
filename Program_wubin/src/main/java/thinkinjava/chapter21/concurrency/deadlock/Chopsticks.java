package thinkinjava.chapter21.concurrency.deadlock;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.deadlock
 * @email wubin326@qq.com
 * @date 2019/01/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/22        wubin            0.0.1
 */
public class Chopsticks {
    private boolean token = false;
    public synchronized void take() throws InterruptedException {
        while (token){
            wait();
        }
        token = true;
    }

    public synchronized void drop(){
        token = false;
        notifyAll();
    }
}
