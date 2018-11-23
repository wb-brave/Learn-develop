package thinkinjava.chapter15.generics.arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class CaptureConversion {

    static <T> void f1(Holder<T> holder){
        T item = holder.getItem();
        System.out.println(item.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder){
        f1(holder);
    }

    public static void main(String[] args) {
        Holder<Integer> holder = new Holder<>(1);
        f1(holder);
        f2(holder);
        Holder holder1 = new Holder();
        holder1.setItem(new Object());
        f2(holder1);
        f1(holder1);
        Holder<?> holder2 = new Holder<>(1.0);
        f1(holder2);
        f2(holder2);
    }
}
