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
public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {

    public final E e;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        this.e = e;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "first=" + first +
                ", second=" + second +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }
}
