package thinkinjava.chapter18.stream;

import java.io.*;

/**
 * @author wubin
 * @Description IO重定向操纵的是字节流，不是字符流所以需要使用inputStream。。而不是reader
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1               重定向输入输出流
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        /**
         * 保存标准输出流
         */
        PrintStream printStream = System.out;

        /**
         * 打开一个文件输入流
         * 打开一个输出流
         */
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
                "/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/java/thinkinjava/chapter18/stream/Redirecting.java"));
        PrintStream stream = new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/wufan/Desktop/redirecting.out")));

        /**
         * 将标准的输入输出流设置为自定义的
         */
        System.setIn(inputStream);
        System.setOut(stream);
        System.setErr(stream);

        /**
         * 将打开的输入流包装为bufeeredreader
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 开始读取文件
         */
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }

        /**
         * 关闭输入流
         */
        stream.close();

        /**
         * 恢复为标准的输出流
         */
        System.setOut(printStream);
    }
}
