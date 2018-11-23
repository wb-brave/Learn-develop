package thinkinjava.chapter15.generics.arrays;

import java.util.Objects;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class Holder<T> {

    private T item;

    public Holder() {
    }

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // if (o == null || getClass() != o.getClass()) return false;
        // Holder<?> holder = (Holder<?>) o;
        return Objects.equals(item, o);
    }

    @Override
    public int hashCode() {

        return Objects.hash(item);
    }

    public static void main(String[] args) {
        Holder<Apple> holder = new Holder<>(new Apple());
        Apple item = holder.getItem();
        holder.setItem(item);
        /**
         * 不能向上转型，以为是两种不同的Holder
         */
        // Holder<Fruit> fhold = holder;
        Holder<? extends Fruit> fhold = holder;
        Fruit f = fhold.getItem();
        item = (Apple) fhold.getItem();
        try {
            Orange orange = (Orange) fhold.getItem();
        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * 不可以进行这种操作，因为使用的是通配符，意味着可以是fruit下的任何事物，
         * 编译器无法验证 这种情况的安全性
         */
        // fhold.setItem(new Apple());
        System.out.println(fhold.equals(item));
    }
}
