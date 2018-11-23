package thinkinjava.chapter15.generics;

import util.generator.RandomGenerator;

import java.math.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wubin
 * @Description 使用策略模式完成真正的泛华
 * 策略模式=====可以将变化的事物完全隔离到一个函数对象中
 * 函数对象=====实质在某种程度上行为想函数的对象，与普通方法不同的是
 * 他可以传递出去，并能用友多个调用之间的持久化的状态
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class Functional {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer result = reduce(integers, new IntegerAdder());
        System.out.println(result);

        result = reduce(integers, new IntegerSubtracter());
        System.out.println(result);

        System.out.println(filter(integers, new GreaterThan<Integer>(4)));

        System.out.println(forEach(integers, new MultiplyingIntegerCollector()).result());

        System.out.println(forEach(filter(integers, new GreaterThan<Integer>(4)),
                new MultiplyingIntegerCollector()).result());

        MathContext mathContext = new MathContext(7);
        List<BigDecimal> lbd = Arrays.asList(
                new BigDecimal(1.1, mathContext), new BigDecimal(2.2, mathContext),
                new BigDecimal(3.3, mathContext), new BigDecimal(4.4, mathContext)
                );
        BigDecimal reduce = reduce(lbd, new BigDecimalAdder());
        System.out.println(reduce);

        System.out.println(filter(lbd,
                new GreaterThan<BigDecimal>(new BigDecimal(3))));

        // Use the prime-generation facility of BigInteger:
        List<BigInteger> lbi = new ArrayList<BigInteger>();
        BigInteger bi = BigInteger.valueOf(11);
        for(int i = 0; i < 11; i++) {
            lbi.add(bi);
            bi = bi.nextProbablePrime();
        }
        System.out.println(lbi);

        BigInteger rbi = reduce(lbi, new BigIntegerAdder());
        System.out.println(rbi);
        // The sum of this list of primes is also prime:
        System.out.println(rbi.isProbablePrime(5));

        List<AtomicLong> lal = Arrays.asList(
                new AtomicLong(11), new AtomicLong(47),
                new AtomicLong(74), new AtomicLong(133));
        AtomicLong ral = reduce(lal, new AtomicLongAdder());
        System.out.println(ral);

        System.out.println(transform(lbd,new BigDecimalUlp()));

    }

    /**
     * 通过调用combiner将迭代器中的元素每个都结合，并返回结合后的结果
     *
     * @param seq
     * @param combiner
     * @param <T>
     * @return
     */
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> iterator = seq.iterator();
        if (iterator.hasNext()) {
            T next = iterator.next();
            /**
             * 遍历迭代器中所有的元素
             */
            while (iterator.hasNext()) {
                T next1 = iterator.next();
                next = combiner.combine(next, next1);
            }
            return next;
        }
        //如果seq是空，直接返回null
        return null;
    }

    /**
     * 面向接口编程，第二个参数是需要后续使用匿名实现类来添加实际的行为
     *
     * @param seq
     * @param collector
     * @param <T>
     * @return
     */
    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> collector) {
        for (T t : seq) {
            collector.function(t);
        }
        return collector;
    }

    /**
     * 将迭代器中的元素全部放入泛型化的list中
     *
     * @param seq
     * @param function
     * @param <R>
     * @param <T>
     * @return
     */
    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> function) {
        ArrayList<R> rs = new ArrayList<>();
        for (T t : seq) {
            rs.add(function.function(t));
        }
        return rs;
    }

    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate unaryPredicate) {
        ArrayList<T> ts = new ArrayList<>();
        for (T t : seq) {
            if (unaryPredicate.test(t)) {
                ts.add(t);
            }
        }
        return ts;
    }

    // To use the above generic methods, we need to create
    // function objects to adapt to our particular needs:
    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class
    IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class
    BigDecimalAdder implements Combiner<BigDecimal> {
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class
    BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class
    AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            // Not clear whether this is meaningful:
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    // We can even make a UnaryFunction with an "ulp"
    // (Units in the last place):
    static class BigDecimalUlp
            implements UnaryFunction<BigDecimal, BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            /**
             * 标识 x 的最小精度
             */
            return x.ulp();
        }
    }

    /**
     * 过滤条件
     *
     * @param <T>
     */
    static class GreaterThan<T extends Comparable<T>>
            implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector
            implements Collector<Integer> {
        private Integer val = 1;

        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        public Integer result() {
            return val;
        }
    }
}

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T t);
}

interface Collector<T> extends UnaryFunction<T, T> {
    //根据收集的参数的出结果
    T result();
}

interface UnaryPredicate<T> {
    boolean test(T x);
}