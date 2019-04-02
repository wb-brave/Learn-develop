package thinkinjava.chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wubin
 * @Description 关于线程的异常：1、并不能被try--catch获取到
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/03
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/03        wubin            0.0.1
 */
public class ExceptionThread implements Runnable{


    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("in thread catch you");
        }
    }

    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(new ExceptionThread());
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("catch you");
        }
        // executorService.shutdown();
    }
}
