package thinkinjava.chapter18.file.afterexercise;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.afterexercise
 * @email wubin326@qq.com
 * @date 2018/09/30
 */
public class DirList1 {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list((file, name) -> {
                return Pattern.compile(args[0]).matcher(name).matches() &&
                        (Collections.disjoint(
                                Arrays.asList(args).subList(1, args.length),
                                //region 以后替换
                                new ArrayList<>()
                                //endregion
//                                new Text
                        ));
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list
                ) {
            System.out.println(dirItem);
        }
    }
}
