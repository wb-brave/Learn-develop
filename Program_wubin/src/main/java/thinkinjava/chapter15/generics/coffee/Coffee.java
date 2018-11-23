package thinkinjava.chapter15.generics.coffee;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.coffee
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class Coffee {

    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
