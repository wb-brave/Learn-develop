package thinkinjava.chapter18.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * 对charbuffer进行编码和解码
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1                 交换字符
 */
public class UseingBuffers {

    /**
     * 原书demo只能交换偶数为的字符
     * @param buffer
     */
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            /**
             * 增加一层判断使得兼容奇数的字符
             */
            if (buffer.hasRemaining()){
                char c2 = buffer.get();
                buffer.reset();
                buffer.put(c2).put(c1);
            }else {
                buffer.reset();
                buffer.put(c1);
            }
        }
    }

    public static void main(String[] args) {
        char[] data = "UseingBuffers".toCharArray();
        ByteBuffer byteBuffer = ByteBuffer.allocate(data.length * 2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        charBuffer.put(data);
        System.out.println(charBuffer.rewind());

        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());

        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());


    }
}
