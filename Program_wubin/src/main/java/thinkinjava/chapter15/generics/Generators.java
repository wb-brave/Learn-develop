package thinkinjava.chapter15.generics;

import util.generator.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class Generators {

    // public static <T extends Collection> Collection<T> fill(
    public static <T> Collection<T> fill(
            Collection<T> collection,
            Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(gen.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        Collection<Integer> fill = fill(new ArrayList<Integer>(), new Fibonacci(), 10);
        for (Integer integer : fill) {
            System.out.print(integer + " ");
        }

    }
}
