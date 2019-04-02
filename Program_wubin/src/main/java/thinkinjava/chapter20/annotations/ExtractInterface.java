package thinkinjava.chapter20.annotations;

import java.lang.annotation.*;

/**
 * @author wubin
 * @Description 使用自定义注解把一个类的public方法提取出来
 * @project Learn-develop
 * @package thinkinjava.chapter20.annotations
 * @email wubin326@qq.com
 * @date 2018/12/29
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/29        wubin            0.0.1
 */
@Target(ElementType.TYPE)
/**
 * 这个策略标识:当使用该注解获得想要的信息之后
 * 不需要保存这个注解的信息
 */
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    String value();
}
