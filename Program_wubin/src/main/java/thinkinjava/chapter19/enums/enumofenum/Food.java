package thinkinjava.chapter19.enums.enumofenum;

/**
 * @author wubin
 * @Description 通过实现接口使枚举子类化（唯一办法）
 * 在进行枚举的枚举
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.enumofenum
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public interface Food {

    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
        @Override
        public void test() {

        }
    }

    enum Dessert implements Food {
        TIREMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
        @Override
        public void test() {

        }
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUNNOUS, VINDALOD;
        @Override
        public void test() {

        }
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_CODDEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
        @Override
        public void test() {

        }
    }

    void test();
    int i = 10;
    String s = "wubin";
}
/**
 * 反编译的结果
 Compiled from "Food.java"
 public interface thinkinjava.chapter19.enums.enumofenum.Food {
 public static final int i;
 public static final java.lang.String s;
 public abstract void test();
 }
 */
