package thinkinjava.chapter18.stream;

import java.io.StringReader;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/10
 */
public class MemoryInput {

    public static void main(String[] args) throws Exception {

        StringReader stringReader = new StringReader(BufferedInputFile.read("/Users/wufan/Desktop/test.txt"));
        int c;
        /**
         * stringReader.read()以int形式返回下一个字节，所以输出是需要强转为char(对于不同的了流会有不同的情况)要谨慎使用
         */
        while ((c = stringReader.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
