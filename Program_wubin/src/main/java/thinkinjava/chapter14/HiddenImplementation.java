package thinkinjava.chapter14;

import thinkinjava.chapter14.interfacea.A;
import thinkinjava.chapter14.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class HiddenImplementation {

    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':因为不在同一个包下
        // if (a instanceof C) {
        //     C c = (C) a;
        //     c.g();
        // }
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    /**
     * 通过反射去调用
     * @param a
     * @param methodName
     * @throws Exception
     */
    static void callHiddenMethod(Object a, String methodName)
            throws Exception {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
