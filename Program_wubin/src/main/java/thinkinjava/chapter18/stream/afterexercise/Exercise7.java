package thinkinjava.chapter18.stream.afterexercise;

import java.io.BufferedReader;
import java.io.FileReader;
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
public class Exercise7 {

    public static void read(String filename, String arg1) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> linkedList = new LinkedList<>();
        while ((s = reader.readLine()) != null) {
            //region exercise8 转换为大写
            //            linkedList.add(s.toUpperCase());
            //endregion
            //region exercise9 通过命令行参数（要查找的单词），将包含此单词的行打印
            if (arg1!=null){
                if (s.contains(arg1))
                    linkedList.add(s);
            }
            //endregion
        }
        reader.close();
//        Collections.reverse(linkedList);
        /**
         * 反序迭代
         */
        Iterator<String> iterator = linkedList.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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
