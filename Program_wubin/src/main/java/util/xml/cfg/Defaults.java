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
public class Defaults {

    /**
     * defaults的直系子节点，以后可以添加其他的
     */
    private JavaFileInfo javaFileInfo;
    private ExcelFileInfo excelFileInfo;

    public Defaults() {
    }

    public JavaFileInfo getJavaFileInfo() {
        return javaFileInfo;
    }

    public void setJavaFileInfo(JavaFileInfo javaFileInfo) {
        this.javaFileInfo = javaFileInfo;
    }

    public ExcelFileInfo getExcelFileInfo() {
        return excelFileInfo;
    }

    public void setExcelFileInfo(ExcelFileInfo excelFileInfo) {
        this.excelFileInfo = excelFileInfo;
    }
}
