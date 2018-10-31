package thinkinjava.chapter18.file.eightonezero;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author wubin
 * @Description "灵巧打印机"
 * 遍历文件时，帮助文件更友好的方式输出
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.eightonezero
 * @email wubin326@qq.com
 * @date 2018/10/08
 */
public class PPrint {
    public static String pformat(Collection<?> c) {
        if (c.size() == 0)
            return "[ ]";
        StringBuilder result = new StringBuilder("[");
        for (Object item : c
                ) {
            if (c.size() != 1) {
                result.append("\n   ");
            }
            result.append(item);
        }
        if (c.size() != 1) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }
    public static void pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }
}
