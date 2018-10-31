package thinkinjava.chapter19.enums.enumofenum;

import org.junit.Test;
import thinkinjava.chapter18.stream.OSExecute;

import static thinkinjava.chapter19.enums.enumofenum.Food.*;
import static org.junit.Assert.*;

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
public class FoodTest {

    @Test
    public void test(){
        Food food = Appetizer.SALAD;
        food = MainCourse.BURRITO;
        food = Dessert.CREME_CARAMEL;
        food = Coffee.DECAF_CODDEE;
        OSExecute.command("javap /Users/wufan/wubin/github/Learn-develop/Program_wubin/target/classes/thinkinjava/chapter19/enums/enumofenum/FoodImpl.class");
    }
}