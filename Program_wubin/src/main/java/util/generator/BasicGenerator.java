package util.generator;

import thinkinjava.chapter15.generics.Fibonacci;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        /**
         * 俩种方式构造这个对象
         */
        BasicGenerator<Fibonacci> fibonacciBasicGenerator = new BasicGenerator<>(Fibonacci.class);
        BasicGenerator.create(Fibonacci.class);
    }
}
