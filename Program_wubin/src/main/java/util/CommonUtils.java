package util;

/**
 * @author wubin
 * @Description
 * 一些公共方法的工具类合集
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
    public static final void getSysProps(){
        String[] keys = { "java.version", "java.vendor", "java.vendor.url", "java.home",
                "java.vm.specification.version", "java.vm.specification.vendor", "java.vm.specification.name",
                "java.vm.version", "java.vm.vendor", "java.vm.name", "java.specification.version",
                "java.specification.vendor", "java.specification.name", "java.class.version", "java.class.path",
                "java.library.path", "java.io.tmpdir", "java.compiler", "java.ext.dirs", "os.name", "os.arch",
                "os.version", "file.separator", "path.separator", "line.separator", "user.name", "user.home",
                "user.dir" };

        for (String key : keys) {
            String value = System.getProperty(key);
            System.out.println(key + " : " + value);
        }
    }
}
