package util.readexcel;

import ch.qos.logback.classic.db.names.ColumnName;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import thinkinjava.chapter12.exceptions.CleanUp;
import util.Null;
import util.NullObject;
import util.ioutil.IOUtils;
import util.sets.Countries;
import util.xml.XMLHelper;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.readexcel
 * @email wubin326@qq.com
 * @date 2018/12/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/19        wubin            0.0.1
 */
public class ExcelUtilsTest {

    @Test
    public void getExcelDataBySheet() throws Exception{
        XMLHelper.getInstance().getDefaults();
        Workbook workbook = ExcelUtils.parseExcel(ExcelUtils.ExcelConst.FILENAME);
        Sheet sheet = workbook.getSheet("第六批指定规则");
        Map<String, LinkedList<String>> columnsBySheet = ExcelUtils.getColumnsBySheet(sheet);
        List<Map<String, Map<String, LinkedList<String>>>> allExcelDataToList = ExcelUtils.getAllExcelDataToList(workbook);
        // System.out.println();
        Iterator<Map.Entry<String, LinkedList<String>>> iterator = columnsBySheet.entrySet().iterator();
        LinkedList<String> rulename = new LinkedList<>();
        LinkedList<String> funcname = new LinkedList<>();
        LinkedList<String> methodname = new LinkedList<>();
        while (iterator.hasNext()) {
            LinkedList<String> value = iterator.next().getValue();
            if (value.get(0).equals("规则名称")) {
                rulename = value;
            }
            if (value.get(0).equals("入参")) {
                funcname = value;
            }
            if (value.get(0).equals("规则所在文件名")) {
                methodname = value;
            }
        }
        String rname = rulename.toString();
        String fname = funcname.toString();
        String mname = methodname.toString();

        System.out.println(buildRuleInfo(rname,fname,mname));
        String info = buildRuleInfo(rname, fname, mname);
        IOUtils.outStringToFile(info,"/Users/wufan/Desktop/codeinfo.txt");
    }

    public String buildRuleInfo(String... names) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < names.length; i++) {
            String splitname = names[i].substring(names[i].indexOf(",") + 1, names[i].length()-1);
            if (i!=2){
                sb.append(splitname).append(";");
            }else {
                sb.append(splitname);
            }
        }
        return sb.toString().replaceAll(" ","");
    }

}