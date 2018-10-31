package thinkinjava.chapter18.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * <p>
 * 对于不能放入内存的非常大的文件，
 * 使用内存映射技术来假定它是放在内存中的
 * 而且可以完全将它视为非常大的数组进行访问
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class LargeMappedFiles {

    /**
     * 标识16进制数 需要使用x而不是*
     * 128m
     */
    static int length = 0x2FFFFFF;

    public static void main(String[] args) throws IOException {
        /**
         * MappedByteBuffer
         * extends ByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("/Users/wufan/Desktop/test.dat", "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);//必须指定起点，和长度；由此看出我们可以映射部分文件
        for (int i = 0; i < length; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
        System.out.println("Finish writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print(mappedByteBuffer.get(i) + " ");
        }
    }
}
