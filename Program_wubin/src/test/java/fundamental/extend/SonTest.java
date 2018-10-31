package fundamental.extend;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description 子类初始化时，会将父类的静态语句块首先初始化
 * @project Learn-develop
 * @package fundamental.extend
 * @email wubin326@qq.com
 * @date 2018/10/26
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/26        wubin            0.0.1
 */
public class SonTest {

    @Test
    public void test() {
        new Son();
    }
}