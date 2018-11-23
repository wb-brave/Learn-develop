package thinkinjava.chapter15.generics;

/**
 * @author wubin
 * @Description 参数协变
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class CovariantAndGenericReturnType {

    void test(DerivedGetter d) {
        Derived derived = d.get();
    }
    void test1(Getter d) {
        Getter getter = d.get();
        GenericGetter genericGetter = d.get();
    }
    void test2(Getter d, Getter d2, GenericGetter gg) {
        d.set(d2);
        // d.set(gg);//错误因为自定义参数决定了getter只接受getter类型参数
    }
}

class Base {
}

class Derived extends Base {
}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    Derived get();
}

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
    void set(T arg);
}

/**
 * 这样限制了GenericGetter中的方法致接受Getter类型的参数
 */
interface Getter extends GenericGetter<Getter>{}
