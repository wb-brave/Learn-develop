package thinkinjava.chapter18.stream;

import java.io.*;

/**
 * @author wubin
 * @Description
 * printWriter对数据进行格式化输出便于阅读
 * 但是如果为了输出可供另一个"流"进行恢复的数据
 * 则需要使用DataInputStream(面向字节，所以文件输入输出流要使用input/outStream)
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/11
 */
public class BasicFileOutput {

    static String file = "/Users/wufan/Desktop/test2.out";

    public static void main(String[] args) {

        try {
            LineNumberReader bufferedReader = new LineNumberReader(new BufferedReader(new StringReader(BufferedInputFile.read("/Users/wufan/Desktop/test 2.java"))));
            //region 通过包装流进行修饰
//            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            //endregion
            PrintWriter printWriter = new PrintWriter(file);
            int lineCount = 1;
            String s;
            while ((s = bufferedReader.readLine()) != null) {
//                printWriter.println(lineCount++ + ": " + s);
                printWriter.println(bufferedReader.getLineNumber() + ": " + s);
            }
            printWriter.close();
            System.out.println(BufferedInputFile.read(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
