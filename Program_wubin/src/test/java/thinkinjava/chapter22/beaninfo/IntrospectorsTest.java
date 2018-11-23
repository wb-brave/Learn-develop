package thinkinjava.chapter22.beaninfo;

import org.junit.Test;

import java.beans.Introspector;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter22.beaninfo
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class IntrospectorsTest {

    @Test
    public void test(){
        Introspectors introspectors = new Introspectors();
        introspectors.main(null);
    }
}