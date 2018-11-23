package thinkinjava.chapter15.generics.arrays;

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
public class Wildcards {

    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        // holder.setItem(arg); // Warning:
        //   Unchecked call to setItem(T) as a
        //   member of the raw type Holder
        // holder.setItem(new Wildcards()); // Same warning

        // Can't do this; don't have any 'T':
        // T t = holder.getItem();

        // OK, but type information has been lost:
        Object obj = holder.getItem();
    }
    // Similar to rawArgs(), but errors instead of warnings:

    /**
     * 虽然某种意义上可以将Holder<?>理解为Holder
     * 但是前者指的是具有某种具体类型的同构集合
     * 后者指任何类型的组合
     * @param holder
     * @param arg
     */
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.setItem(arg); // Error:
        //   setItem(capture of ?) in Holder<capture of ?>
        //   cannot be applied to (Object)
        // holder.setItem(new Wildcards()); // Same error

        // Can't do this; don't have any 'T':
        // T t = holder.getItem();

        // OK, but type information has been lost:
        Object obj = holder.getItem();
    }
    static <T> T exact1(Holder<T> holder) {
        T t = holder.getItem();
        return t;
    }
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.setItem(arg);
        T t = holder.getItem();
        return t;
    }
    static <T>
    T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.setItem(arg); // Error:
        //   setItem(capture of ? extends T) in
        //   Holder<capture of ? extends T>
        //   cannot be applied to (T)
        T t = holder.getItem();
        return t;
    }
    static <T>
    void wildSupertype(Holder<? super T> holder, T arg) {
        holder.setItem(arg);
        // T t = holder.getItem();  // Error:
        //   Incompatible types: found Object, required T

        // OK, but type information has been lost:
        Object obj = holder.getItem();
    }
    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        Object r1 = exact1(raw); // Warnings:
        //   Unchecked conversion from Holder to Holder<T>
        //   Unchecked method invocation: exact1(Holder<T>)
        //   is applied to (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // Must return Object
        Long r4 = exact1(bounded);

        // Long r5 = exact2(raw, lng); // Warnings:
        //   Unchecked conversion from Holder to Holder<Long>
        //   Unchecked method invocation: exact2(Holder<T>,T)
        //   is applied to (Holder,Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng); // Error:
        //   exact2(Holder<T>,T) cannot be applied to
        //   (Holder<capture of ?>,Long)
        // Long r8 = exact2(bounded, lng); // Error:
        //   exact2(Holder<T>,T) cannot be applied
        //   to (Holder<capture of ? extends Long>,Long)

        // Long r9 = wildSubtype(raw, lng); // Warnings:
        //   Unchecked conversion from Holder
        //   to Holder<? extends Long>
        //   Unchecked method invocation:
        //   wildSubtype(Holder<? extends T>,T) is
        //   applied to (Holder,Long)
        Long r10 = wildSubtype(qualified, lng);
        // OK, but can only return Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        // wildSupertype(raw, lng); // Warnings:
        //   Unchecked conversion from Holder
        //   to Holder<? super Long>
        //   Unchecked method invocation:
        //   wildSupertype(Holder<? super T>,T)
        //   is applied to (Holder,Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Error:
        //   wildSupertype(Holder<? super T>,T) cannot be
        //   applied to (Holder<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Error:
        //   wildSupertype(Holder<? super T>,T) cannot be
        //  applied to (Holder<capture of ? extends Long>,Long)
    }
}
