package thinkinjava.chapter15.generics.arrays;

import java.util.List;

/**
 * @author wubin
 * @Description 使用统配符是由某个特定的类的任何基类 也就是说这个基类的子类都可以添加
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class SuperTypeWildcards {

    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
    }
}
