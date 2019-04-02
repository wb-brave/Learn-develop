package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/04        wubin            0.0.1
 */
public class Atomicity {

    int i;
    public void f(){
        i++;
    }
    public void g(){
        i += 3;
    }

}
