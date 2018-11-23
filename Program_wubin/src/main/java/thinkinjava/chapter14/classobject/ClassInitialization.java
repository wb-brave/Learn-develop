package thinkinjava.chapter14.classobject;

import java.util.Random;

/**
 * @author wubin
 * @Description
 *  类的初始化会延迟在对【静态方法】（注意默认构造器是瘾式的静态方法）或者 非静态的常量域
 *  实例化对象时
 *  不论什么情况都是先初始化静态域
 *  然后执行构造函数
 * @project Learn-develop
 * @package thinkinjava.chapter5.classobject
 * @email wubin326@qq.com
 * @date 2018/11/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/01        wubin            0.0.1
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    /**
     * 实例化对象时
     * 不论什么情况都是先初始化静态域
     * 然后执行构造函数
     *
     * staticNonFinal如果是个final类型的就不会触发初始化
     */
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }

    public Initable2() {
        System.out.println("lalala");
    }
}

class Initable3 extends Initable2{
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        /**
         * 不会触发Initable的初始化
         * 因为是通过 Initable.class 来获得类的引用
         * 并且访问的是Initable的 静态常量（static final）成员
         */
        System.out.println(Initable.staticFinal);
        /**
         * 触发类的初始化，因为这个静态常量访问了别的非静态常量
         */
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("thinkinjava.chapter14.classobject.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

        //region 使用构造函数来产生实例
        System.out.println("创建实例");
        new Initable3();
        //endregion
    }
}