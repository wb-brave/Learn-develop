package thinkinjava.chapter12.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter12.exceptions
 * @email wubin326@qq.com
 * @date 2018/11/27
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/27        wubin            0.0.1
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger(LoggingException.class.getName());

    public LoggingException() {

        StringWriter stringWriter = new StringWriter();
        printStackTrace(new PrintWriter(stringWriter));
        logger.severe(stringWriter.toString());
    }
}
