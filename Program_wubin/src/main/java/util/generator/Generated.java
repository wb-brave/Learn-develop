package util.generator;

import util.sets.CollectionData;

import java.lang.reflect.Array;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.generator
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class Generated {

    public static <T> T[] array(T[] a, Generator<T> gen) {
        /**
         * 填充一个已经存在的数组
         * .toArray(a)标识返回a锁持有的类型的数组
         */
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(gen, a.length).toArray(a);
    }
}
