package thinkinjava.chapter15.generics.bounds;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/21        wubin            0.0.1
 */
public class SelfBouding {

    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).getElement();
        a = a.getElement();
        C c = new C();
        c = c.setAndGet(new C());
    }
}

class Selfbounded<T extends Selfbounded<T>> {
    T element;

    Selfbounded<T> set(T element) {
        this.element = element;
        return this;
    }

    T getElement() {
        return element;
    }
}

class A extends Selfbounded<A> {
}

class B extends Selfbounded<A> {
}

class C extends Selfbounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return getElement();
    }
}

//<editor-fold desc="这样是不行的，因为D不在他的边界之内,因为D不是Selfbounded的类型参数">
class D{}
// class E extends Selfbounded<D>{}
//</editor-fold>

class F extends Selfbounded{}
