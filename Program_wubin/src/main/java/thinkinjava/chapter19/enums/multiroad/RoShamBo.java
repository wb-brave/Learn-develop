package thinkinjava.chapter19.enums.multiroad;

import thinkinjava.chapter19.enums.util.Enums;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.multiroad
 * @email wubin326@qq.com
 * @date 2018/10/31
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/31        wubin            0.0.1
 */
public class RoShamBo {
    /**
     * void前面的泛型是用来限制形参的
     *
     * @param a
     * @param b
     * @param <T>
     */
    public static <T extends Competitor<T>> void match(T a, T b) {
        /**
         * string format
         * %d 表示数字
         * 'c' 直接嵌入到起前面的String字符串
         * %s表示 字符串 和 boolean
         */
        System.out.println(a + " vs. " + b + " : " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>>
    void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            /**
             * 随机获取enum的实例
             */
            match(Enums.random(rsbClass),Enums.random(rsbClass));
        }
    }
}
