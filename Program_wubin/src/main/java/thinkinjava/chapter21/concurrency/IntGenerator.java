package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/03
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/03        wubin            0.0.1
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel(){
        canceled = true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
