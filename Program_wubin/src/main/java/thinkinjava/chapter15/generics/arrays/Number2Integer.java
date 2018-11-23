package thinkinjava.chapter15.generics.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class Number2Integer {
    public static void main(String[] args) {
        Number[] num = new Integer[10];
        num[0] = new Integer(150);
        num[1] = 12;
        //因为数组内部有协变性
        num[2] = 15.2;
        List<? extends Number> lnum = new ArrayList<Integer>();
        // lnum.add(15.2);
        // lnum.add(new Integer(10));
    }
}
