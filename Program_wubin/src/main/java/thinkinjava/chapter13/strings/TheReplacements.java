package thinkinjava.chapter13.strings;

import thinkinjava.chapter18.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*! wwww Here's     a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of llll text by looking for
    the special delimiters, then process the
    extracted block. !*/

/**
 * @author wubin
 * @Description 正则表达式中的替换文本的方法
 * @project Learn-develop
 * @package thinkinjava.chapter13.strings
 * @email wubin326@qq.com
 * @date 2018/12/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/04        wubin            0.0.1
 */
public class TheReplacements {

    public static void main(String[] args) {
        String read = TextFile.read("/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/java/thinkinjava/chapter13/strings/TheReplacements.java");
        final Matcher matcher = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(read);
        if (matcher.find()){
           read = matcher.group(1);
        }
        /**
         * 将1个或多个空格替换为一个空格
         * String的这个方法最终调用的还是
         * pattern的解析方法
         */
        read = read.replaceAll(" {2,}", " ");
        /**
         * 替换每行开头的一个或多个空格为""
         * 必须要使用标记 Pattern.MULTILINE==?m
         */
        read = read.replaceAll("(?m)^ +","");
        System.out.println(read);
        read = read.replaceFirst("[aeiou]","(VOWEL1)");
        final StringBuffer sb = new StringBuffer();
        final Matcher matcher1 = Pattern.compile("[aeiou]").matcher(read);
        while (matcher1.find()){
            matcher1.appendReplacement(sb, matcher1.group().toUpperCase());
        }
        /**
         * 将剩余未处理的部分，添加到sb中
         */
        matcher1.appendTail(sb);
        System.out.println(sb.toString());
    }
}
