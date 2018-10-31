package thinkinjava.chapter18.stream;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/10
 */
public class BufferedInputFile {

    public static String read(String fileName) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/java/thinkinjava/chapter18/stream/BufferedInputFile.java";
        System.out.println(read(fileName));
    }
}
