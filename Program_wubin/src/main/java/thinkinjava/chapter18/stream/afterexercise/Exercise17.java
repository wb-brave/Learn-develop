package thinkinjava.chapter18.stream.afterexercise;

import thinkinjava.chapter18.util.TextFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 结合TextFile，Map统计一个字符在文件中出现的次数
 * 把结果保存在map中
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream.afterexercise
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date           Author          Version            Description
 * -----------------------------------------------------------------------
 */
public class Exercise17 {

    public static void main(String[] args) {
        String s = TextFile.read("/Users/wufan/Desktop/test2.java");
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (Pattern.compile("[a-zA-Z]").matcher(c.toString()).matches()){

                if (hashMap.containsKey(c)){
                    hashMap.put(c,hashMap.get(c)+1);
                }else {
                    hashMap.put(c,1);
                }
            }
        }
        System.out.println(Arrays.asList(hashMap).toString());
    }
}
