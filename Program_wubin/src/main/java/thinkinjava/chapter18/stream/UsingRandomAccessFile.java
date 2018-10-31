package thinkinjava.chapter18.stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/16
 * Modification History:
 * Date           Author          Version            Description
 * -----------------------------------------------------------------------
 */
public class UsingRandomAccessFile {

    static String file = "/Users/wufan/Desktop/rtest.dat";

    static void display() throws IOException {
        RandomAccessFile r = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("value " + i + ": " + r.readDouble());
        }
        System.out.println(r.readUTF());
        r.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile r = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            r.writeDouble(i*Math.PI);
        }
        r.writeUTF("the end of the file");
        r.close();
        display();
        /**
         * 重新打开访问的流
         */
        r = new RandomAccessFile(file, "rw");
        /**
         * seek()去寻在元素位置，因为double是8个字节，
         * 所以使用index乘以8即可定位
         */
        r.seek(4*8);
        r.writeDouble(6.66);
        r.close();
        display();
    }
}
