package thinkinjava.chapter18.util;


import util.MyConst;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
public class TextFile extends ArrayList<String> {

    public TextFile(String filename, String splitter) {
        //读取文件，根据规则去分割
        super(Arrays.asList(read(filename).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String filename) {
        this(filename, "\n");
    }

    public TextFile() {
    }

    public static String read(String filename) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(
                            new File(filename).getAbsoluteFile()));
            String s;
            try {
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * @param filename
     * @param text
     * @return void
     * @throws
     * @author wubin
     * @date 2018-10-16 17:36
     * @description 将一个string文件写入到指定的文件上（filename）  
     * @since
     */
    public static void write(String filename, String text) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(filename).getAbsoluteFile()));
            try {
                printWriter.print(text);
            } finally {
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(new File(filename).getAbsoluteFile()));

            /**
             * 对this对象进行迭代输出
             */
            try {
                for (String s : this) {
                    writer.println(s);
                }
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String file = read("Program_wubin/src/main/java/thinkinjava/chapter18/util/TextFile.java");
        write("Program_wubin/src/main/java/thinkinjava/chapter18/util/test.txt", file);
        TextFile file1 = new TextFile("Program_wubin/src/main/java/thinkinjava/chapter18/util/test.txt");
        file1.write("Program_wubin/src/main/java/thinkinjava/chapter18/util/text2.txt");
        TreeSet<String> treeSet = new TreeSet<>(new TextFile("Program_wubin/src/main/java/thinkinjava/chapter18/util/TextFile.java", "\\W+"));
        System.out.println(treeSet.headSet("a"));
    }

    /**
     * 根据指定路径、文件名、后缀名来生成指定的文件
     * 特定的需求下
     * @param absoluteDir
     * @param ext
     * @param filenames
     * @throws Exception
     */
    public static void buildFile(String absoluteDir, String ext, String[] filenames) throws Exception {
        switch (ext.toUpperCase()) {
            default:
            case MyConst.FILEEXT_JAVA:
                buildJavaFile(absoluteDir, ext, filenames);
        }
    }

    private static void buildJavaFile(String dir, String ext, String[] filenames) throws Exception {

        FileChannel channel = null;
        String realFilename = null;
        String packageName = null;
        StringBuilder stringBuilder = null;
        try {
            for (String filename : filenames) {
                stringBuilder = new StringBuilder();
                realFilename = dir + "/" + filename + ext;
                packageName = getPackageName(dir);
                channel = new FileOutputStream(realFilename).getChannel();
                stringBuilder.append("package ").append(packageName).append(";")
                        .append("public class ").append(filename)
                        .append(" extends Individual {")
                .append("public ").append(filename).append("(String name) {super(name);}")
                .append("public ").append(filename).append("() {super();}")
                .append("}");
                channel.write(ByteBuffer.wrap(stringBuilder.toString().getBytes()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            channel.close();
        }

    }

    /**
     * 讲传入的路径解析成java类的可识别字符串
     *
     * @param dir
     * @return
     */
    private static String getPackageName(String dir) {
        String systemPath = dir.substring(dir.indexOf("java") + 5);
        return systemPath.replace("/", ".");
    }
}
