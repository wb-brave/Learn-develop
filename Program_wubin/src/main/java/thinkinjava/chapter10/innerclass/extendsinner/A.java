package thinkinjava.chapter10.innerclass.extendsinner;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10.innerclass.extendsinner
 * @email wubin326@qq.com
 * @date 2018/11/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/26        wubin            0.0.1
 */
public class A {
    public A(String s) {
        System.out.println("A{" + s + "}");
    }
}

class InnerA{
    class Ia{
        public Ia(String s) {
            System.out.println("A{" + s + "}");
        }
    }
}

class InnerB{
    class Ib extends InnerA.Ia{
        public Ib(InnerA innerA) {
            innerA.super("wubnin");
        }
    }
}
