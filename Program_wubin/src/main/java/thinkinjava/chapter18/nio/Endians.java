package thinkinjava.chapter18.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * 通过字节存放模式设置来改变字符中的字节次序
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class Endians {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[12]);

        byteBuffer.asCharBuffer().put("asdasd");
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.asCharBuffer().put("asdasd");
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.asCharBuffer().put("asdasd");
        System.out.println(Arrays.toString(byteBuffer.array()));

    }
}
