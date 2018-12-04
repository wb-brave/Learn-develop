package thinkinjava.chapter13.strings;

import java.util.*;
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
public class Groups {

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    static public final String my = "Wu shi shen jin beni Ja";
    public static void main(String[] args) {
        Pattern compile = null;
        compile = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$");
        Matcher matcher = null;
        matcher = compile.matcher(POEM);
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.print(" [" + matcher.group(i) + "]");
            }
            System.out.println();
        }

        System.out.println("==========================");
        /**
         * 匹配所有是小写字母开头的词
         * 为什么需要这样，，
         */
        compile = Pattern.compile("(^[a-z]|\\s+[a-z])\\S+");
        matcher = compile.matcher(my);
        final HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        String m = null;
        while (matcher.find()) {
            m = matcher.group();
            if (!stringIntegerHashMap.containsKey(m)) {
                stringIntegerHashMap.put(m, 1);
            } else {
                stringIntegerHashMap.put(m, stringIntegerHashMap.get(m) + 1);
            }
        }
        final Iterator<Map.Entry<String, Integer>> iterator = stringIntegerHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
    }
}
