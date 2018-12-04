package thinkinjava.chapter13.strings;

import thinkinjava.chapter18.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 对文件进行正则表达式
 * @project Learn-develop
 * @package thinkinjava.chapter13.strings
 * @email wubin326@qq.com
 * @date 2018/12/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/04        wubin            0.0.1
 */
public class JGrep {
    private static final String[] mArgs = {"/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/java/thinkinjava/chapter13/strings/JGrep.java"
            ,"(?i)(^[sct]|\\s+[Ssct])\\w+"};
    //也可以使用 "\\b[Ssct]\\w+" \\b代表一个单词的边界
    public static void main(String[] args) {
        final Pattern compile = Pattern.compile(mArgs[1]);
        final Matcher matcher = compile.matcher("");
        int index = 0;
        for (String line : new TextFile(mArgs[0])) {
            matcher.reset(line);
            while (matcher.find()){
                System.out.println(index++ + ": " + matcher.group() + ": " + matcher.start());
            }
        }
    }
}
