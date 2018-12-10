package util.generator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.generator
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class ConvertToPrimitiveClassTest {

    @Test
    public void convert() {
        int i= 0;
        final Integer[] convert = ConvertToPrimitiveClass.convert(i);
    }
}