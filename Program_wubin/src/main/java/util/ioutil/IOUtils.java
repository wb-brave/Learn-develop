package util.ioutil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.ioutil
 * @email wubin326@qq.com
 * @date 2018/12/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/20        wubin            0.0.1
 */
public class IOUtils {

    /**
     * 将string类型的信息，写入指定的文件中
     * @param message
     * @param filename
     * @param fileSize
     * @return
     */
    public static boolean outStringToFile(String message, String filename){
        boolean success = Boolean.TRUE;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            FileChannel channel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
            channel.write(byteBuffer);
        } catch (IOException e) {
            success = Boolean.FALSE;
        }
        return success;
    }
}
