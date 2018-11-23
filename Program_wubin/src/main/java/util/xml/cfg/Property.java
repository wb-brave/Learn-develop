package util.xml.cfg;

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
public class Property {
    private String name;
    private String value;
    private Ref ref;
    private String type;

    public Property() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) throws Exception {
        if (!(value==null && value.equals(""))) {
            this.value = value;
        } else {
            this.value = value;
        }

    }

    public void setRef(Ref ref) {
        this.ref = ref;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}