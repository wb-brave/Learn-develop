package thinkinjava.chapter18.stream.afterexercise;

import thinkinjava.chapter18.stream.BufferedInputFile;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream.afterexercise
 * @email wubin326@qq.com
 * @date 2018/10/10
 */
public class Exercise12 {

    public static String file = "/Users/wufan/Desktop/exercise12.out";

    public static void read(String filename, String arg1) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> linkedList = new LinkedList<>();

        while ((s = reader.readLine()) != null) {
            //region exercise8 转换为大写
            linkedList.add(s);
            //endregion、
            //region exercise9 通过命令行参数（要查找的单词），将包含此单词的行打印
//            if (arg1!=null){
//                if (s.contains(arg1))
//                    linkedList.add(s);
//            }
            //endregion

        }
        reader.close();
//        Collections.reverse(linkedList);
        /**
         * 反序迭代
         */
//        Iterator<String> iterator = linkedList.descendingIterator();
        /**
         * 正序迭代
         */
        Iterator<String> iterator = linkedList.iterator();
        int lineCount = 1;
        PrintWriter printWriter = new PrintWriter(file);
        while (iterator.hasNext()) {
            //写入文件的时候，不会帮你创建文件目录，需要有真实的目录存在
            printWriter.println(lineCount++ + ": " + iterator.next());
        }
        printWriter.close();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            read(args[0], null);
        } else if (args.length == 2) {
            read(args[0], args[1]);
        } else {
            System.err.println("未配置命令行参数");
            System.exit(1);
        }
    }

}
