package thinkinjava.chapter17.containers;

import java.util.*;

/**
 * @author wubin
 * @Description 按对象的比较函数对元素进行排序
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/13
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/13        wubin            0.0.1
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<>();
        Collections.addAll(set, "1,2,3,4,5,6,7,8".split(","));
        System.out.println(set);
        String low = set.first();
        String high = set.last();
        System.out.println("low " + low + " " + "high " + high);
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i <= 6; i++){
            if (i == 3) {
                low = iterator.next();
            }
            if (i == 6) {
                high = iterator.next();
            } else iterator.next();
        }
        System.out.println("low " + low + " " + "high " + high);
        System.out.println(set.subSet(low, high));
        System.out.println(set.headSet(high));
        System.out.println(set.tailSet(low));
    }
}
