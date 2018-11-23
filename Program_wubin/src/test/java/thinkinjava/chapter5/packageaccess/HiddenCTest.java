package thinkinjava.chapter5.packageaccess;

import org.junit.Test;
import thinkinjava.chapter14.packageaccess.HiddenC;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.packageaccess
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class HiddenCTest {

    @Test
    public void test(){
        HiddenC.makeA().f();
    }
}