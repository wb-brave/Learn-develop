package thinkinjava.chapter17.containers;

import org.junit.Test;
import util.generator.*;
import util.sets.Countries;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/21
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/21        wubin            0.0.1
 */
public class TestParamTest {

    @Test
    public void testInteger(){

        String s = "0x9e";
        System.out.println(Integer.decode(s));
        // System.out.println(Integer.valueOf(s));
    }
}