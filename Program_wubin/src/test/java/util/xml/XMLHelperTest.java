package util.xml;

import org.junit.Test;
import util.xml.cfg.*;

import static org.junit.Assert.*;

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
public class XMLHelperTest {

    @Test
    public void getDefaults() throws Exception {

        XMLHelper instance = XMLHelper.getInstance();
        Defaults defaults = instance.getDefaults();
        JavaFileInfo javaFileInfo = defaults.getJavaFileInfo();
        for (Property property : javaFileInfo.getProperties()) {
            System.out.println(property.getName() + " " + property.getValue());
        }

    }
}