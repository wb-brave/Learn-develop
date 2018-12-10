package thinkinjava.chapter16.arrays;

import util.Null;

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
public class ComparingArrays {

    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        System.out.println(Arrays.equals(a1, a2));
        a2[3] = 11;
        System.out.println(Arrays.equals(a1, a2));
        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"),
                new String("Hi"), new String("Hi")};
        System.out.println(Arrays.equals(s1, s2));

        NullObject[] b1 = {new NullObject(1), new NullObject(2), new NullObject(3)};
        NullObject[] b2 = {new NullObject(1), new NullObject(2), new NullObject(3)};

        System.out.println(Arrays.equals(b1, b2));

        /**
         * 深度比较多维数组
         */
        double[][] doubles = new double[2][4];
        Arrays.fill(doubles[0], 6.6);
        Arrays.fill(doubles[1], 8.8);
        double[][] doubles1 = new double[2][4];
        Arrays.fill(doubles1[0], 6.6);
        Arrays.fill(doubles1[1], 8.8);
        // System.out.println(Arrays.deepToString(doubles));
        System.out.println(Arrays.deepEquals(doubles1,doubles));
    }
}

class NullObject {
    public int i = 0;

    public NullObject(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof NullObject)
            return this.i == ((NullObject) object).i;
        return false;
    }
}