package util.sets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class Sets {
    public static <T> Set<T> unino(Set<T> a, Set<T> b){
        Set<T> ts = new HashSet<>(a);
        ts.addAll(b);
        return ts;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> ts = new HashSet<>(a);
        /**
         * 移除集合a中不包含集合b中的元素
         */
        ts.retainAll(b);
        return ts;
    }

    /**
     * 移除集合a中所有包含集合b的元素
     * @param superset
     * @param subset
     * @param <T>
     * @return
     */
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset){
        Set<T> ts = new HashSet<>(superset);
        ts.removeAll(subset);
        return ts;
    }

    /**
     * 返回除了两个集合交集之外的所有元素
     * @param superset
     * @param subset
     * @param <T>
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        return difference(unino(a,b),intersection(a,b));
    }
}
