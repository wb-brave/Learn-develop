package thinkinjava.chapter10.innerclass;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass
 * @email wubin326@qq.com
 * @date 2018/11/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/26        wubin            0.0.1
 */
public class InheritInner extends WithInner.Inner{

    public InheritInner(WithInner withInner) {
        /**
         * .super()编译器不会提示出来
         * 需要自己手打
         * 继承内部类的时候这样提供了必要的引用
         */
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        InheritInner inheritInner = new InheritInner(withInner);
    }
}

class WithInner{
    class Inner{}
}
