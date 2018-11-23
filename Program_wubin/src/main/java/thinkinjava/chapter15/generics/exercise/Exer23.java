package exercise;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class Exer23 {

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(),15);
        new Foo2<Widge>(new Widge.WidegFactory(),12);
    }
}

interface Factory<T> {
    T create(Integer e);
}

class Foo2<T> {
    private T t;

    public  <F extends Factory<T>> Foo2(F factory,Integer integer) {
        t = factory.create(integer);
    }

}

class IntegerFactory implements Factory<Integer> {

    @Override
    public  Integer create(Integer integer) {
        return integer;
    }
}

class Widge {

    private int length;

    public Widge(int length) {
        this.length = length;
    }

    public Widge() {
    }

    public static class WidegFactory implements Factory<Widge> {
        @Override
        public Widge create(Integer integer) {
            return new Widge(integer);
        }
    }

    @Override
    public String toString() {
        return "Widge{" +
                "length=" + length +
                '}';
    }
}
