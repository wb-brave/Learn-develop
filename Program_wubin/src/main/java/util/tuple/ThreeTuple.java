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
public class ThreeTuple<A,B,C> extends TwoTuple<A,B>{

    public final C c;

    public ThreeTuple(A a, B b, C c) {
       super(a,b);
        this.c = c;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", c=" + c +
                '}';
    }
}
