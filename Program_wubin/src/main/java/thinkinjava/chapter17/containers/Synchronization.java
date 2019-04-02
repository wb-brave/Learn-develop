package thinkinjava.chapter17.containers;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class Synchronization {

    public static void main(String[] args) {
        Collection<String> c =
                Collections.synchronizedCollection(
                        new ArrayList<String>());
        List<String> list = Collections.synchronizedList(
                new ArrayList<String>());
        Set<String> s = Collections.synchronizedSet(
                new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(
                new TreeSet<String>());
        Map<String,String> m = Collections.synchronizedMap(
                new HashMap<String,String>());
        Map<String,String> sm =
                Collections.synchronizedSortedMap(
                        new TreeMap<String,String>());
    }
}
