package util.xml.cfg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.xml.cfg
 * @email wubin326@qq.com
 * @date 2018/11/06
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/06        wubin            0.0.1
 */
public class JavaFileInfo {
    private List list = new ArrayList();

    public JavaFileInfo() {
    }

    public void addProperty(Property property) {
        this.list.add(property);
    }

    public Property[] getProperties() {
        return (Property[]) this.list.toArray(new Property[0]);
    }
}
