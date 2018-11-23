package thinkinjava.chapter18.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.util
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class TextFileTest {

    /**
     * wubin.wufan.hhh.ss
     */
    @Test
    public void testTransfer(){
        String s = "wubin/wufan/hhh.ss";
        System.out.println(s.replace("/","."));
        int i = s.indexOf("fan");
        System.out.println(i + " " + s.substring(i+3) + " " + s.substring(8,10));
    }

}