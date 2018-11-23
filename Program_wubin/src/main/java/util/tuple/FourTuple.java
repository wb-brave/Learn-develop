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
public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C>{

    public final D d;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "first=" + first +
                ", second=" + second +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
