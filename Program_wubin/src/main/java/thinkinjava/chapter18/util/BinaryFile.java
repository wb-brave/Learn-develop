package thinkinjava.chapter18.util;

import java.io.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.util
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date           Author          Version            Description
 * -----------------------------------------------------------------------
 */
public class BinaryFile {

    public static byte[] read(File bfile) throws IOException {
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(bfile));
        try {
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            return bytes;
        } finally {
            stream.close();
        }
    }

    public static byte[] read(String filename) throws IOException {
        return read(new File(filename).getAbsoluteFile());
    }

    public static void main(String[] args) throws IOException {
        byte[] read = read("/Users/wufan/Desktop/test2.class");
        for (byte b : read) {
            System.out.println(b);
        }
    }
}
