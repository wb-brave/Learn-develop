package thinkinjava.chapter19.enums.enumofenum;

import thinkinjava.chapter19.enums.util.Enums;

/**
 * @author wubin
 * @Description
 *
 * 使用被接口子类化的enum
 * 完成枚举中的枚举
 * 可以使用内部接口完成这样的行为
 *
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.enumofenum
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public enum Course {

    APPETIZER(Food.Appetizer.class),
    COFFEE(Food.Coffee.class),
    DESSERT(Food.Dessert.class),
    MAINCOURSE(Food.MainCourse.class);

    private Food[] kinds;
    Course(Class<? extends Food> kind) {
        kinds = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(kinds);
    }
}
