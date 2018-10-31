package thinkinjava.chapter18.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.file
 * @email wubin326@qq.com
 * @date 2018/09/30
 */
public class DirListInnerClass {

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length==0){
            list=path.list();
        }else{

            //region Description第一种内部类
//            list = path.list(filter(args[0]));
            //endregion
            list = path.list((dir, name) -> Pattern.compile(args[0]).matcher(name).matches());
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem: list
             ) {
            System.out.println(dirItem);
        }
    }

    /**
     * 使用匿名内部类，形参必须传入final修饰的(这里没设置也可以)，
     * @param regex
     * @return
     */
    public static FilenameFilter filter(String regex){
        return (dir, name) -> Pattern.compile(regex).matcher(name).matches();
    }

}
