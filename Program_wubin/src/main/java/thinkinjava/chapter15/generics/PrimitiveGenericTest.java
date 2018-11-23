package thinkinjava.chapter15.generics;

import util.generator.Generator;
import util.generator.RandomGenerator;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class PrimitiveGenericTest {

    public static void main(String[] args) {
        String[] strings = FArray.fill(new String[7], new RandomGenerator.String(10));
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
        Integer[] integers = FArray.fill(new Integer[7], new RandomGenerator.Integer());
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

    }
}

class FArray {
    public static <T> T[] fill(T[] a, Generator<T> gen) {
        /**
         * foreach作用一般都是遍历一个容器中的所有元素
         * 不适用与修改其中的值，比如为每一个元素赋值的操作
         */
        // for (T t : a) {
        //     t = gen.next();
        // }
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.next();
        }
        return a;
    }
}
