package thinkinjava.chapter21.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency.exercise
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class BasicExec {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int count = 10;
        while (count-- > 0) {
            executorService.execute(new Exer1());
        }
        executorService.shutdown();
    }
}
