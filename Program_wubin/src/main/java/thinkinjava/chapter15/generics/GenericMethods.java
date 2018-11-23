package thinkinjava.chapter15.generics;

/**
 * @author wubin
 * @Description
 * 能使用泛型方法来代替使用泛型类就
 * 尽量使用泛型方法
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class GenericMethods {

    /**
     * <T>这个是泛型参数列表对应后面的形参(T x)
     * eg <T,U> void f(T x,U u)
     * @param x
     * @param <T>
     */
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public <T,U> void f(T x,U u) {
        System.out.println(x.getClass().getName());
    }
    public <T,U> void f(T x,U u,int n) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}