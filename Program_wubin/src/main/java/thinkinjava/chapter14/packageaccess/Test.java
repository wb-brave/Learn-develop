package thinkinjava.chapter14.packageaccess;

import thinkinjava.chapter14.interfacea.A;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.packageaccess
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class Test {
    public static void main(String[] args) {

        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
        /**
         * 没有显式的访问限制符代表是 包访问限制
         * 在同一个包中可以访问
         */
        if (a instanceof C) {
            C c = (C) a;
            c.g();
        }
    }
}

