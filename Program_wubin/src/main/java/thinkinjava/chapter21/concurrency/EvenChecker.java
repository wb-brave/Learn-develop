package thinkinjava.chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/03
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/03        wubin            0.0.1
 */
public class EvenChecker implements Runnable {

    private IntGenerator gen;
    private final int i;

    public EvenChecker(IntGenerator gen, int i) {
        this.gen = gen;
        this.i = i;
    }

    @Override
    public void run() {
        while (!gen.isCanceled()) {
            int val = gen.next();
            /**
             * 这里依赖非任务来消除潜在的竞争
             */
            if (val % 2 != 0) {
                /**
                 * 如果不能整除2
                 * 说明存在异步的风险，因为俩次递增的操作是分开的
                 */
                System.out.println(val + "not even");
                gen.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press control-c to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(gp, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
