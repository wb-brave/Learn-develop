package thinkinjava.chapter16.arrays;

import util.generator.Generated;

import java.util.Arrays;
import java.util.Collections;

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
public class Reverse {

    public static void main(String[] args) {
        CompType[] a =
                Generated.array(new CompType[12], CompType.generator());
        System.out.println("before sorting:");
        System.out.println(Arrays.toString(a));
        /**
         * a必须要实现Comparable接口
         * 将排序，倒序
         */
        Arrays.sort(a,Collections.reverseOrder());
        System.out.println("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
