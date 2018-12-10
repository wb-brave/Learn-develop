package thinkinjava.chapter16.arrays;

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
public class CopyArrays {

    public static void main(String[] args) {
        int i[] = new int[7];
        int j[] = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("j = " + Arrays.toString(j));
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j = " + Arrays.toString(j));
        System.out.println("================================");
        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        System.out.println("k = " + Arrays.toString(k));
        System.out.println("================================");
        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        System.out.println("i = " + Arrays.toString(i));
        System.out.println("================================");
        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, new Integer(99));
        System.out.println("u = " + Arrays.toString(u));
        System.out.println("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length / 2, v.length);
        System.out.println("u = " + Arrays.toString(u));
        System.out.println();

        BerylliumSphere[] b1 = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        BerylliumSphere[] b2 = new BerylliumSphere[6];
        System.arraycopy(b1, 0, b2, 0, b1.length);
        /**
         * b2因为初始化的时候并没有创建对象
         * 最后结果输出时却可以看到对象
         * 由此看出，是对引用的copy属于浅克隆
         */
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(b2));
    }
}
