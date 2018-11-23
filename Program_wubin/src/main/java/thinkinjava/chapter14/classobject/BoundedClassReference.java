package thinkinjava.chapter14.classobject;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.classobject
 * @email wubin326@qq.com
 * @date 2018/11/01
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/01        wubin            0.0.1
 */
public class BoundedClassReference {

    public static void main(String[] args) {
        Class<? extends Number> wildClass = int.class;
        /**
         * Integer继承Number
         * 但不是他的子类
         */
        // Class<Number> normal = int.class;
    }
}
