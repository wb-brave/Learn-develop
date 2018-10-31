package thinkinjava.chapter18.stream;

import java.io.*;

/**
 * @author wubin
 * @Description * printWriter对数据进行格式化输出便于阅读
 * 但是如果为了输出可供另一个"流"进行恢复的数据
 * 则需要使用DataInputStream(面向字节，所以文件输入输出流要使用input/outStream)
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/12
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws Exception {

        String filename = "/Users/wufan/Desktop/data.txt";
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)));

        dataOutputStream.writeDouble(6.66);
        dataOutputStream.writeUTF("wubin");
        dataOutputStream.write(8);
        dataOutputStream.close();
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readDouble());
        dataInputStream.close();
    }
}
