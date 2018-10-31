package thinkinjava.chapter19.enums.enumofenum;

import thinkinjava.chapter19.enums.util.Enums;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.enumofenum
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    Security values[];

    SecurityCategory(Class<? extends Security> ec) {
        values = ec.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN;
        }

        enum Bond implements Security {
            MUNICIPAL, KUNL;
        }
    }

    public Security randomSecurity() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSecurity());
        }
    }
}
