package thinkinjava.chapter13.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 对于pattern类的一些标记flag进行测试
 * @project Learn-develop
 * @package thinkinjava.chapter13.strings
 * @email wubin326@qq.com
 * @date 2018/12/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/04        wubin            0.0.1
 */
public class ReFlags {
    public static void main(String[] args) {
        /**
         * Pattern.CASE_INSENSITIVE 忽略大小写 (?i)
         * Pattern.MULTILINE 匹配输入的每一行，(?m)
         * Pattern.COMMENTS 忽略所有的空格符，并且以#符号开头的也忽略 (?m)
         * Pattern.DOTALL 标识 . 匹配所有字符，默认情况不匹配行终结符 (?s)
         */

        final Pattern compile = Pattern.compile("^Java", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        // final Pattern compile = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = compile.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expressions\n" +
                        "Regular expressions are in Java");
        while (m.find()){
            /**
             * 返回匹配的字符串
             */
            System.out.println(m.group());
        }
    }
}
