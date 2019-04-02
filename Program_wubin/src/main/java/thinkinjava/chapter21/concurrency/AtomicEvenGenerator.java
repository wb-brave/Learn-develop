package thinkinjava.chapter21.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/07        wubin            0.0.1
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int next() {
        return atomicInteger.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
