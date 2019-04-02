package thinkinjava.chapter17.containers;

import util.sets.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author wubin
 * @Description treeMap是Sortedmap的唯一实现
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/17        wubin            0.0.1
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>(new CountingMapData(10));
        System.out.println(treeMap);
        Integer firstKey = treeMap.firstKey();
        Integer lastKey = treeMap.lastKey();
        System.out.println(firstKey + " " + lastKey);
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        for (int i = 0; i <= 6; i++) {
            if (i==3){
                firstKey = iterator.next();
            }
            if (i==6){
                lastKey = iterator.next();
            }else{
                iterator.next();
            }
        }
        System.out.println(firstKey + " " + lastKey);
        System.out.println(treeMap.subMap(firstKey,lastKey));
        System.out.println(treeMap.headMap(lastKey));
        System.out.println(treeMap.tailMap(firstKey));
    }
}
