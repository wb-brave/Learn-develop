package thinkinjava.chapter5.classobject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.classobject
 * @email wubin326@qq.com
 * @date 2018/11/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/01        wubin            0.0.1
 */
public class ToyTestTest {

    @Test
    public void testChar(){
        char[] cs = {'c','a','d','c','b'};
        System.out.println(cs.getClass().getTypeName());
    }
}