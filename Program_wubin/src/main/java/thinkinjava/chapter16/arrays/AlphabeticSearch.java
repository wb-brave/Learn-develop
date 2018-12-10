package thinkinjava.chapter16.arrays;

import util.generator.Generated;
import util.generator.RandomGenerator;

import java.util.Arrays;

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
public class AlphabeticSearch {

    public static void main(String[] args) {
        final String[] array = Generated.array(new String[30], new RandomGenerator.String(5));
        /**
         * 因为sort的时候使用-实现了Comparator的String.CASE_INSENSITIVE_ORDER类
         * 所以在使用的时候必须使用重载方法java.util.Arrays#binarySearch(java.lang.Object[], java.lang.Object, java.util.Comparator)
         * String.CASE_INSENSITIVE_ORDER类作为第三个形参
         */
        Arrays.sort(array,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(array));
        final int i = Arrays.binarySearch(array, array[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println("index: " + i + "\n" + array[i]);
    }
}
