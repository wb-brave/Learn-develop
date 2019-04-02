package thinkinjava.chapter20.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations.database
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
public @interface Uniqueness {

    Constraints CONSTRAINTS() default @Constraints(unique = true);
}
