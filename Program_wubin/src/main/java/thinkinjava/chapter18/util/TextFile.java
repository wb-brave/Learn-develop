package thinkinjava.chapter18.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.util
 * @email wubin326@qq.com
 * @date 2018/10/16
 * Modification History:
 * Date           Author          Version            Description
 * -----------------------------------------------------------------------
 */
public class TextFile extends ArrayList<String>{

    public TextFile(String filename,String splitter) {
        //读取文件，根据规则去分割
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")){
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename,"\n");
    }

    public TextFile() {
    }

    public static String read(String filename){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                        new File(filename).getAbsoluteFile()));
            String s;
            try {
                while ((s=bufferedReader.readLine())!=null){
                    stringBuilder.append(s).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * @author wubin
     * @date 2018-10-16 17:36
     * @param filename
     * @param text
     * @description
     * 将一个string文件写入到指定的文件上（filename）  
     * @return void
     * @throws
     * @since
     */
    public static void write(String filename,String text){
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(filename).getAbsoluteFile()));
            try {
                printWriter.print(text);
            }finally {
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String filename){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(new File(filename).getAbsoluteFile()));

            /**
             * 对this对象进行迭代输出
             */
            try {
                for(String s:this){
                    writer.println(s);
                }
            }finally {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String file = read("Program_wubin/src/main/java/thinkinjava/chapter18/util/TextFile.java");
        write("Program_wubin/src/main/java/thinkinjava/chapter18/util/test.txt",file);
        TextFile file1 = new TextFile("Program_wubin/src/main/java/thinkinjava/chapter18/util/test.txt");
        file1.write("Program_wubin/src/main/java/thinkinjava/chapter18/util/text2.txt");
        TreeSet<String> treeSet = new TreeSet<>(new TextFile("Program_wubin/src/main/java/thinkinjava/chapter18/util/TextFile.java", "\\W+"));
        System.out.println(treeSet.headSet("a"));
    }
}
