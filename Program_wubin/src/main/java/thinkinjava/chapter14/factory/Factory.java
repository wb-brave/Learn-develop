package thinkinjava.chapter14.factory;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.factory
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public interface Factory<T> {

    T create();
}
