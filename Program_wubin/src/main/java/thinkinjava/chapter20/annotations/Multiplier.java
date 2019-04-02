package thinkinjava.chapter20.annotations;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
@ExtractInterface("IMultiplier")
public class Multiplier {

    public int multiply(int x, int y) {
        return x * y;
    }

    private int add(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Multiplier multiplier = new Multiplier();
        System.out.println("12 * 3 = " + multiplier.multiply(12, 3));
    }
}
