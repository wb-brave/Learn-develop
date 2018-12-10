package thinkinjava.chapter16.arrays;

import java.util.Arrays;
import java.util.Random;

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

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    /**
     * 随机选择不同的口味，通过do  while来进行控制
     *
     * @param n
     * @return
     */
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length)
            throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            /**
             * 可以省略花括号。。。
             * 这个循环是先执行do语句块
             * 在判断while中的条件
             * 如果通过则跳出循环；否则继续执行do语句块
             */
            do
                t = rand.nextInt(FLAVORS.length);
            while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static BerylliumSphere[] test(int n) {
        return new BerylliumSphere[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavorSet(8)));
    }
} /* Output:
[Rum Raisin, Mint Chip, Mocha Almond Fudge]
[Chocolate, Strawberry, Mocha Almond Fudge]
[Strawberry, Mint Chip, Mocha Almond Fudge]
[Rum Raisin, Vanilla Fudge Swirl, Mud Pie]
[Vanilla Fudge Swirl, Chocolate, Mocha Almond Fudge]
[Praline Cream, Strawberry, Mocha Almond Fudge]
[Mocha Almond Fudge, Strawberry, Mint Chip]
*///:~
