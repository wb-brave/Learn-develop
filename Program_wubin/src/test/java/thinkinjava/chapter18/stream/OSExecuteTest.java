package thinkinjava.chapter18.stream;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1
 */
public class OSExecuteTest {

    /**
     * 错误: 找不到类: OSExecuteTest

     thinkinjava.chapter18.exception.OSExecuteException: ERRORS EXECUTING javap OSExecuteTest

     at thinkinjava.chapter18.stream.OSExecute.command(OSExecute.java:44)
     at thinkinjava.chapter18.stream.OSExecuteTest.command(OSExecuteTest.java:23)


     需要使用绝对路径的class文件
     */
    @Test
    public void command() {
        OSExecute.command("javap OSExecuteTest");
    }
}