package thinkinjava.chapter13.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter13.strings
 * @email wubin326@qq.com
 * @date 2018/12/04
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/04        wubin            0.0.1
 */
public class StartEnd {

    public static String input =
            "As long as there is injustice, whenever a\n" +
                    "Targathian baby cries out, wherever a distress\n" +
                    "signal sounds among the stars ... We'll be there.\n" +
                    "This fine ship, and this fine crew ...\n" +
                    "Never give up! Never surrender!";

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        public Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
            }
            System.out.println(message);
        }
    }

    static void examine(String s, String regex) {
        final Display display = new Display(regex);
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(s);
        /**
         * 这个方法可以在任意位置开始匹配
         */
        while (matcher.find()){
            display.display("find() '" + matcher.group() +
                    "' start = "+ matcher.start() + " end = " + matcher.end());
        }
        /**
         * 只要输入的第一部分匹配就会成功
         */
        if(matcher.lookingAt()) // No reset() necessary
            display.display("lookingAt() start = "
                    + matcher.start() + " end = " + matcher.end());
        /**
         * 只有在整个输入都匹配的情况下才会成功
         */
        if(matcher.matches()) // No reset() necessary
            display.display("matches() start = "
                    + matcher.start() + " end = " + matcher.end());
    }

    public static void main(String[] args) {
        for (String s : input.split("\n")) {
            System.out.println("input : " + s);
            for (String s1 : new String[]{"\\w*ere\\w*", "\\w*ere", "T\\w+", "Never.*?!"}) {
                examine(s,s1);
            }
            System.out.println("================================");
        }

    }
}
