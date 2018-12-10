package thinkinjava.chapter16.arrays;

import util.generator.Generated;
import util.generator.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wubin
 * @Description 对string进行排序
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class StringSorting {
    public static void main(String[] args) {
        final String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
        System.out.println("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        System.out.println("==================================");
        System.out.println("Reverse sort: " + Arrays.toString(sa));

        /**
         * 如果不指定后面一个形参的话，
         * 默认是将大写字母开头的与小写字母开头的字符串分为两类
         * 优先输出大写字母比较的结果
         */
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(sa));
    }
}
