package thinkinjava.chapter18.nio;

import java.nio.ByteBuffer;

/**
 * @author wubin
 * @Description 从bytebuffer中读取各种不同类型的数据(没有boolean基本数据类型)
 * @project Learn-develop
 * @package thinkinjava.chapter18.nio
 * @email wubin326@qq.com
 * @date 2018/10/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/19        wubin            0.0.1
 */
public class GetDataFrombf {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        int i = 0;
        /**
         * 通过检查每个值来判断初始化bytebuffer时
         * 他的分配方式是否为将值自动清零
         */
        while (i++ < byteBuffer.limit()) {
            if (byteBuffer.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i);
        /**
         * 回到最初的起点
         */
        byteBuffer.rewind();

        byteBuffer.asCharBuffer().put("Howdy");

        char c;
        while ((c = byteBuffer.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();
        byteBuffer.rewind();

        byteBuffer.asShortBuffer().put((short) 1231);
        System.out.println(byteBuffer.getShort());
        byteBuffer.rewind();

        byteBuffer.asLongBuffer().put(99471142);
        System.out.println(byteBuffer.getLong());
        byteBuffer.rewind();

        byteBuffer.asDoubleBuffer().put(99471142);
        System.out.println(byteBuffer.getDouble());
        byteBuffer.rewind();

        byteBuffer.asFloatBuffer().put(99471142);
        System.out.println(byteBuffer.getFloat());
        byteBuffer.rewind();

    }
}
