package thinkinjava.chapter18.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description  更理想的方式是通过特殊方法transferTo（）transferTo（）
 * 来完成这一类的操作
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1
 */
public class ChannelCopy {

    public static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }

        FileChannel in = new FileInputStream(args[0]).getChannel();
        FileChannel out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1) {
            /**
             * 准备写数据，如果不调用此方法
             * 不会有数据写入到文件
             */
            buffer.flip();
            out.write(buffer);
            /**
             * write之后，数据还在bytebuff中
             * 手动清空，一遍其他流进行数据传输
             */
            buffer.clear();
        }
    }
}
