package thinkinjava.chapter21.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/02        wubin            0.0.1
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        int i = 10;
        while (i-- > 0) {
            results.add(executorService.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }

    }
}

class TaskWithResult implements Callable {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public Object call() throws Exception {
        return "result of TaskWithResult: " + id;
    }
}