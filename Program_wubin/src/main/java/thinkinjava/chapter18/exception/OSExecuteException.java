package thinkinjava.chapter18.exception;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.exception
 * @email wubin326@qq.com
 * @date 2018/10/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/18        wubin            0.0.1                 为进程控制设计的异常
 */
public class OSExecuteException extends RuntimeException {

    public OSExecuteException() {
        super();
    }

    public OSExecuteException(String message) {
        super(message);
    }
}
