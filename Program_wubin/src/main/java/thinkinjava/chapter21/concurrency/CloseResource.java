package thinkinjava.chapter21.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author wubin
 * @Description 当执行io操作时，线程阻塞，可以使用此方法进行释放资源
 * @project Learn-develop
 * @package thinkinjava.chapter21.concurrency
 * @email wubin326@qq.com
 * @date 2019/01/08
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/01/08        wubin            0.0.1
 */
public class CloseResource {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket socket = new ServerSocket(8080);
        InputStream server = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IOBlocked(server));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("shutting down all threads");
        executorService.shutdownNow();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("closing " + server.getClass().getSimpleName());
        //释放线程 但是只关闭这个好像并没有起作用
        server.close();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("closing " + System.in.getClass().getSimpleName());
        //释放线程 需要俩个都关闭才行
        System.in.close();
    }
}
