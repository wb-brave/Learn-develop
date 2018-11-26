package thinkinjava.chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter10
 * @email wubin326@qq.com
 * @date 2018/11/23
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/23        wubin            0.0.1
 */
public class DotThisTest {

    @Test
    public void testInner(){
        DotThis.Inner inner = new DotThis().new Inner();
    }

}