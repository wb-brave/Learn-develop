package thinkinjava.chapter19.enums.util;

import thinkinjava.chapter19.enums.autosentmachine.VendingMachine;

import java.util.Random;

/**
 * @author wubin
 * @Description
 *
 * 工具类，简化随机选取枚举实例
 *
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.util
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class Enums {
    public static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] enumConstants) {
        return enumConstants[rand.nextInt(enumConstants.length)];
    }
}
