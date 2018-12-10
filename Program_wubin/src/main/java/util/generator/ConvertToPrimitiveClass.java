package util.generator;

/**
 * @author wubin
 * @Description 创建基本类型数组
 * @project Learn-develop
 * @package util.generator
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class ConvertToPrimitiveClass {

    public static <T> T[] convert(T type){
        return (T[]) new Object[5];
    }

    public static boolean[] primitive(Boolean[] Bs) {
        final boolean[] booleans = new boolean[Bs.length];
        for (int i = 0; i < Bs.length; i++) {
            //自动拆箱
            booleans[i] = Bs[i];
        }
        return booleans;
    }
    public static char[] primitive(Character[] Cs) {
        final char[] chars = new char[Cs.length];
        for (int i = 0; i < Cs.length; i++) {
            //自动拆箱
            chars[i] = Cs[i];
        }
        return chars;
    }
    public static short[] primitive(Short[] Ss) {
        final short[] shorts = new short[Ss.length];
        for (int i = 0; i < Ss.length; i++) {
            //自动拆箱
            shorts[i] = Ss[i];
        }
        return shorts;
    }
    public static byte[] primitive(Byte[] Bs) {
        final byte[] bytes = new byte[Bs.length];
        for (int i = 0; i < Bs.length; i++) {
            //自动拆箱
            bytes[i] = Bs[i];
        }
        return bytes;
    }
    public static int[] primitive(Integer[] integers) {
        final int[] ints = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            //自动拆箱
            ints[i] = integers[i];
        }
        return ints;
    }
    public static long[] primitive(Long[] ls) {
        final long[] longs = new long[ls.length];
        for (int i = 0; i < ls.length; i++) {
            //自动拆箱
            longs[i] = ls[i];
        }
        return longs;
    }
    public static float[] primitive(Float[] fs) {
        final float[] floats = new float[fs.length];
        for (int i = 0; i < fs.length; i++) {
            //自动拆箱
            floats[i] = fs[i];
        }
        return floats;
    }
    public static double[] primitive(Double[] ds) {
        final double[] doubles = new double[ds.length];
        for (int i = 0; i < ds.length; i++) {
            //自动拆箱
            doubles[i] = ds[i];
        }
        return doubles;
    }
}
