package thinkinjava.chapter20.annotations.database;

import java.lang.annotation.*;

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
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {

    String name() default "";
}
