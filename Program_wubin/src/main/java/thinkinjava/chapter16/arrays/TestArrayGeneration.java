package thinkinjava.chapter16.arrays;

import util.generator.*;

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
public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        final boolean[] a1 = ConvertToPrimitiveClass.primitive(
                Generated.array(Boolean.class, new CountingGenerator.Boolean(), size));
        System.out.println("a1 = " + Arrays.toString(a1));
        byte[] a2 = ConvertToPrimitiveClass.primitive(Generated.array(
                Byte.class, new RandomGenerator.Byte(), size));
        System.out.println("a2 = " + Arrays.toString(a2));
        char[] a3 = ConvertToPrimitiveClass.primitive(Generated.array(
                Character.class,
                new RandomGenerator.Character(), size));
        System.out.println("a3 = " + Arrays.toString(a3));
        short[] a4 = ConvertToPrimitiveClass.primitive(Generated.array(
                Short.class, new RandomGenerator.Short(), size));
        System.out.println("a4 = " + Arrays.toString(a4));
        int[] a5 = ConvertToPrimitiveClass.primitive(Generated.array(
                Integer.class, new RandomGenerator.Integer(), size));
        System.out.println("a5 = " + Arrays.toString(a5));
        long[] a6 = ConvertToPrimitiveClass.primitive(Generated.array(
                Long.class, new RandomGenerator.Long(), size));
        System.out.println("a6 = " + Arrays.toString(a6));
        float[] a7 = ConvertToPrimitiveClass.primitive(Generated.array(
                Float.class, new RandomGenerator.Float(), size));
        System.out.println("a7 = " + Arrays.toString(a7));
        double[] a8 = ConvertToPrimitiveClass.primitive(Generated.array(
                Double.class, new RandomGenerator.Double(), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }
}
