package thinkinjava.chapter10;

/**
 * @author wubin
 * @Description 要在这个类的其他类中访问其内部类，需要先获得其对象，再根据.new 创建内部类
 * DotThis.Inner inner = new DotThis().new Inner();
 * @project Learn-develop
 * @package thinkinjava.chapter10
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class DotThis {
    public class Inner{}

    public static void main(String[] args) {
        Inner inner = new DotThis().new Inner();
        DotThis dotThis = new DotThis();
        Inner1 inner1 = dotThis.inner1();
        inner1.out().f();
        //不可以这样使用，this不能作用于static域
        // Inner inner2 = new Inner();
    }

    public class Inner1{
        public DotThis out(){
            /**
             * 返回对外部类的引用
             */
            return DotThis.this;
        }
    }

    public Inner1 inner1(){
        return new Inner1();
    }

    void f(){
        System.out.println("f()");
    }
}
