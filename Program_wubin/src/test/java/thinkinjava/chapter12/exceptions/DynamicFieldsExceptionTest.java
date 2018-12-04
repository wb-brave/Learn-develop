package thinkinjava.chapter12.exceptions;

import org.junit.Test;


/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/27        wubin            0.0.1
 */
public class DynamicFieldsExceptionTest {

    @Test
    public void testArrays() {
        int[][] values = new int[3][2];
        for (int i = 0; i < values.length; i++){
            values[i] = new int[]{1,2};
        }
        System.out.println(values[1][1]);
    }
}