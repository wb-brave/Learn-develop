package thinkinjava.chapter18.nio;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1
 */
public class GetChannel {

    public static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        String filename = "/Users/wufan/Desktop/data.txt";
        /**
         * 使用FileOutputStream流打开文件后，获取通道
         * 之后将信息写入文件
         */
        FileChannel channel = new FileOutputStream(filename).getChannel();
        channel.write(ByteBuffer.wrap("some text ".getBytes()));
        channel.close();

        channel = new RandomAccessFile(filename,"rw").getChannel();
        /**
         * 定位到文件的最后位置
         */
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap("some text ".getBytes()));
        channel.close();
        /**
         * 对于只读访问
         * 必须显示的 ByteBuffer.allocate(BSIZE)
         * 来分配ByteBuffer大小（构造出缓冲器）
         * 分配的大小对于nio非常重要，因为需要快速的移动大量数据
         */
        channel = new FileInputStream(filename).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        channel.read(byteBuffer);
        /**
         * flip 必须通过此方法来让他做好准备让别人来读取存储字节
         * 可以获取到最大的速度（以后探究）
         */
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            System.out.println((char) byteBuffer.get());
        }

    }
}
