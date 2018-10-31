package thinkinjava.chapter18.stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/10
 */
public class FormatMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("/Users/wufan/Desktop/test.txt").getBytes()));
            /**
             * available()返回一个int判断文件是否已经读取完成
             */
            while (dataInputStream.available() != 0){
                System.out.print((char)dataInputStream.readByte());
            }
        }catch (EOFException e){
            System.out.println("End of stream");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
