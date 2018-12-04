package util;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 一些公共方法的工具类合集
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/07        wubin            0.0.1
 */
public final class CommonUtils {

    /**
     * 获取本机系统的相关配置信息
     */
    public static final void getSysProps() {
        String[] keys = {"java.version", "java.vendor", "java.vendor.url", "java.home",
                "java.vm.specification.version", "java.vm.specification.vendor", "java.vm.specification.name",
                "java.vm.version", "java.vm.vendor", "java.vm.name", "java.specification.version",
                "java.specification.vendor", "java.specification.name", "java.class.version", "java.class.path",
                "java.library.path", "java.io.tmpdir", "java.compiler", "java.ext.dirs", "os.name", "os.arch",
                "os.version", "file.separator", "path.separator", "line.separator", "user.name", "user.home",
                "user.dir"};

        for (String key : keys) {
            String value = System.getProperty(key);
            System.out.println(key + " : " + value);
        }
    }

    /**
     * 测试正则表达式是否匹配
     * @param data    目标数据
     * @param pattern 正则表达式
     * @return
     */
    public static final void testRegularExpr(String data, String... patterns) {

        if (judgeNullString(data) && judgeNullString(patterns)) {
            for (String s : patterns) {
                final Pattern pattern = Pattern.compile(s);
                final Matcher matcher = pattern.matcher(data);
                /**
                 * find() 寻找多个匹配的字符串
                 * 会向后迭代匹配
                 */
                while (matcher.find()) {
                    System.out.println(
                            "matchs \"" + matcher.group() + "\" at positions " +
                                    matcher.start() + "-" + (matcher.end() -1)
                    );
                }
            }
        }
    }

    public static final boolean judgeNullString(String... args) {
        for (String arg : args) {
            if (Objects.isNull(arg) && arg == ""){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        try {
            final Class<?> aClass = Class.forName("util.CommonUtils");
            for (Method method : aClass.getMethods()) {
                for (Parameter parameter : method.getParameters()) {
                    System.out.print(parameter.getName() + " ");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
