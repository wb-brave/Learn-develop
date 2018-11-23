package util.xml;

import com.sun.xml.internal.rngom.ast.builder.Include;
import org.apache.commons.digester3.Digester;
import org.omg.PortableInterceptor.Interceptor;
import util.xml.cfg.*;

import java.io.InputStream;

/**
 * @author wubin
 * @Description
 * 解析XML文件的工具类
 * 每个节点对应一个pojo
 * @project Learn-develop
 * @package util.xml
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class XMLHelper {

    private static XMLHelper instance = null;
    private static Defaults defaults = null;

    private static Boolean isInit;

    static {
        isInit = Boolean.FALSE;
    }

    private XMLHelper() {
    }

    public static XMLHelper getInstance() throws Exception {
        if (isInit.equals(Boolean.FALSE)) {
            Boolean var0 = isInit;
            synchronized (isInit) {
                if (isInit.equals(Boolean.FALSE)) {
                    defaults = createDefaults();
                    isInit = Boolean.TRUE;
                }
            }

            instance = new XMLHelper();
        }

        return instance;
    }

    public Defaults getDefaults() {
        return defaults;
    }

    private static Defaults createDefaults() throws Exception {
        Defaults rtn = null;
        String defaultsFileName = "system/service/defaults.xml";
        // if (!StringUtils.isBlank(System.getProperty("appframe.service.default.filename"))) {
        //     defaultsFileName = System.getProperty("appframe.service.default.filename").trim();
        //     System.out.println("Use defaults.xml:" + defaultsFileName);
        // }

        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(defaultsFileName);
        if (input == null) {
            String msg = "获取文件错误";
            throw new Exception(msg);
        } else {
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.addObjectCreate("defaults", Defaults.class.getName());
            digester.addSetProperties("defaults");
            digester.addObjectCreate("defaults/javaFileInfo", JavaFileInfo.class.getName());
            digester.addSetProperties("defaults/javaFileInfo");
            digester.addObjectCreate("defaults/javaFileInfo/property", Property.class.getName());
            digester.addSetProperties("defaults/javaFileInfo/property");
            /**
             * javaFileInfo中的set方法(对应着Defaults中的setJavaFileInfo方法)
             * 而他的子节点property是对应着 util.xml.cfg.JavaFileInfo#addProperty(util.xml.cfg.Property)方 法
             */
            digester.addSetNext("defaults/javaFileInfo", "setJavaFileInfo", JavaFileInfo.class.getName());
            digester.addSetNext("defaults/javaFileInfo/property", "addProperty", Property.class.getName());
            rtn = digester.parse(input);
            return rtn;
        }
    }
}
