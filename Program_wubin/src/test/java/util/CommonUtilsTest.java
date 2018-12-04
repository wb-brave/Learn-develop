package util;

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTable;
import org.junit.Test;
import sun.jvm.hotspot.oops.LocalVariableTableElement;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/07        wubin            0.0.1
 */
public class CommonUtilsTest {

    @Test
    public void getSysProps() {

        CommonUtils.getSysProps();
    }
    @Test
    public void testRegularExpr(){
        String data = "Java now has regular Expressions";
        // CommonUtils.testRegularExpr(data,"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}","s{0,3}");

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