package thinkinjava.chapter16.arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter16.arrays
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class ArrayOfGenericsType<T> {

    T[] array;

    public ArrayOfGenericsType(int size) {
        //不可以直接定义泛型数组,编译器不知道你使用的是什么类型(因为擦除的原因)
        // array = new T[size];
        array = (T[]) new Object[size];
    }
}
