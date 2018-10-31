package thinkinjava.chapter18.nio.fileLock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio.fileLock
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class FileLocking {
    private static final String filename = "/Users/wufan/Desktop/data2.txt";

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        /**
         * 加锁
         */
        FileLock fileLock = fileOutputStream.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("file is locked");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                fileLock.release();
                System.out.println("file release");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fileOutputStream.close();
    }
}
