package thinkinjava.chapter21.concurrency;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/15
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/15        wubin            0.0.1
 */
public class Volatile {

    private static volatile int i = 0;
    private static int i1 = 0;

    public static void f(){
        i++;
    }
    public static void f1(){
        i1++;
    }
}
