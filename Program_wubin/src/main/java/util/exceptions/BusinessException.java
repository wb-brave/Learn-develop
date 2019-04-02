package util.exceptions;

import util.readexcel.ExcelUtils;

/**
 * @author wubin
 * @Description 业务的总异常
 * @project Learn-develop
 * @package util.exceptions
 * @email wubin326@qq.com
 * @date 2018/12/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/20        wubin            0.0.1
 */
public class BusinessException extends Exception {

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
