package thinkinjava.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    /**
     * 匹配的格式类似为
     * sdasd.
     * 或者指定的字符串
     */
    private static Pattern p = Pattern.compile("\\w+\\.|native |final ");

    public static void main(String[] args) {
        // if (args.length < 1) {
        //     System.out.println(usage);
        //     System.exit(0);
        // }
        int lines = 0;
        try {
            Class<?> c = Class.forName("thinkinjava.chapter14.ShowMethods");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 0) {
                for (Method method : methods)
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                    // System.out.println(method.toString());
                for (Constructor ctor : ctors)
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(
                                p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(
                                ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
} 