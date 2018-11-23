package thinkinjava.chapter15.generics.bounds;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.bounds
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class SelfBoundingMethods {

    /**
     * 作用于方法中的时候
     * 意味着将这个方法参数绑定为这个T类型
     * @param arg
     * @param <T>
     * @return
     */
    static <T extends Selfbounded<T>> T f(T arg){
        return arg.set(arg).getElement();
    }

    public static void main(String[] args) {
        A f = f(new A());
    }
}
