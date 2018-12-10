package thinkinjava.chapter16.arrays;

import java.util.Arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/06        wubin            0.0.1
 */
public class MultidimensionalObjectArrays {
    public static void main(String[] args) {
        /**
         * 不要陷入误区，
         * 第二维中放的是一个数组，所以不会有初始化为null的情况
         */
        BerylliumSphere[][] spheres = {
                { new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
                { new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere(),
                        new BerylliumSphere(), new BerylliumSphere() },
        };
        System.out.println(Arrays.deepToString(spheres));
        int[][] ints = {
                { 1, 1 },
                { 1, 1,
                        1, 1 },
                { 1, 1,
                        1, 1,
                        1, 1,
                        1, 1 },
        };
        System.out.println();
        System.out.println(Arrays.deepToString(ints));
    }
} /* Output:
[[Sphere 0, Sphere 1], [Sphere 2, Sphere 3, Sphere 4, Sphere 5], [Sphere 6, Sphere 7, Sphere 8, Sphere 9, Sphere 10, Sphere 11, Sphere 12, Sphere 13]]
*///:~