package thinkinjava.chapter16.arrays;

import util.generator.*;

import java.util.Arrays;

/**
 * @author wubin
 * @Description 在已排序的数组中找值
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class ArraySearching {

    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        final int[] ints = ConvertToPrimitiveClass.primitive(Generated.array(new Integer[25], gen));
        Arrays.sort(ints);
        System.out.println("Before sort: " + Arrays.toString(ints));
        while (true) {
            final Integer next = gen.next();
            int location = Arrays.binarySearch(ints, next);
            if (location >= 0) {
                System.out.println("Location of " + next + " is " + location +
                        ", a[" + location + "] = " + ints[location]);
                break; // Out of while loop
            }
        }
    }
}
