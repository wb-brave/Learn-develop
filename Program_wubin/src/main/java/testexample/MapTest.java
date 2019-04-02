package testexample;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package testexample
 * @email wubin326@qq.com
 * @date 2019/01/09
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/09        wubin            0.0.1
 */
public class MapTest {

    private static int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 找最接近容量的2^n的值
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n ^= n >>> 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        System.out.println(tableSizeFor(20));
    }
}
