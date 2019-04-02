package util.xml.cfg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.readexcel
 * @email wubin326@qq.com
 * @date 2018/12/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/20        wubin            0.0.1
 */
public class ExcelFileInfo {
    List list = new ArrayList();

    public ExcelFileInfo() {
    }

    public void addProperty(Property property){
        this.list.add(property);
    }

    public Property[] getProperties(){
        return (Property[]) this.list.toArray();
    }
}
