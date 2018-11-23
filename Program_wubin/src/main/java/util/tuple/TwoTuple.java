package util.tuple;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) { first = a; second = b; }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}