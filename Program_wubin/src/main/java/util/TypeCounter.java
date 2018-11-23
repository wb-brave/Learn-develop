package util;

import java.util.HashMap;

/**
 * @author wubin
 * @Description 对一个类进行计算
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {

    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
        Class<?> type = object.getClass();
        /**
         * isAssignableFrom运行时检查
         * 判断传进来的type
         * 是否为basetype的子类或者自身
         */
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(object + " incorrect type: " +
                    type + " , should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer count = get(type);
        put(type, count == null ? 1 : count + 1);
        Class<?> superclass = type.getSuperclass();
        /**
         * 通过自旋将所有的类型信息（包括出去基类的所有父类）
         * 计数并存入map
         */
        if (superclass != null && superclass!=baseType && baseType.isAssignableFrom(superclass)) {
            countClass(superclass);
        }
    }

    /**
     * 重写此方法，格式化输出
     * @return
     */
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> pair
                : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }
}
