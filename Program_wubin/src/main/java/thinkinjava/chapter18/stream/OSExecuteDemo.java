package thinkinjava.chapter18.stream;

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
public class OSExecuteDemo {

    public static void main(String[] args) {
        /**
         * 需要使用绝对路径的class文件
         */
        OSExecute.command("javap /Users/wufan/wubin/github/Learn-develop/Program_wubin/target/classes/thinkinjava/chapter18/stream/OSExecuteDemo.class");
    }
}
