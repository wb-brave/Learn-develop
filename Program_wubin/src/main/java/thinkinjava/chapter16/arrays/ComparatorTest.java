package thinkinjava.chapter16.arrays;

import util.generator.Generated;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class ComparatorTest {

    public static void main(String[] args) {
        final CompType[] a = Generated.array(new CompType[12], CompType.generator());
        System.out.println("before rsorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new CompTypeComparator());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}

class CompTypeComparator implements Comparator<CompType> {

    @Override
    public int compare(CompType o1, CompType o2) {
        return (o1.j > o2.j ? 1 : -1);
    }
}
