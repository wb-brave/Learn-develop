package thinkinjava.chapter15.generics;


/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class FactoryConstraint {

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widge>(new Widge.WidegFactory());
    }
}

interface Factory<T>{
    T create();
}

class Foo2<T>{
    private T t;
    public <F extends Factory<T>> Foo2(F factory){
        t = factory.create();
    }
}

class IntegerFactory implements Factory<Integer>{
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widge{
    public static class WidegFactory implements Factory<Widge>{
        @Override
        public Widge create() {
            return new Widge();
        }
    }
}