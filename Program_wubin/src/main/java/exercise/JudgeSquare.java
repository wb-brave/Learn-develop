package exercise;


import com.sun.javafx.css.CalculatedValue;

import java.math.BigDecimal;

/**
 * @author wubin
 * @Description 给定四个坐标判断是否构成一个正方形
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2018/09/21
 */
public class JudgeSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        long sideLength_1 = calculatedValue(p1, p2);
        long sideLength_2 = calculatedValue(p1, p3);
        long sideLength_3 = calculatedValue(p1, p4);
        if (sideLength_1 == sideLength_2 && sideLength_1 != sideLength_3) {
            return sideLength_1 * 2 == sideLength_3 ? true : false;
        } else if (sideLength_1 == sideLength_3 && sideLength_1 != sideLength_2) {
            return sideLength_1 * 2 == sideLength_2 ? true : false;
        } else if (sideLength_1 != sideLength_3 && sideLength_1 != sideLength_2 && sideLength_2 == sideLength_3) {
            return sideLength_3 * 2 == sideLength_1 ? true : false;
        } else {
            return false;
        }
    }

    public long calculatedValue(int[] p1, int[] p) {
        long x = new Long(Math.abs(p1[0] - p[0]));
        long y = new Long(Math.abs(p1[1] - p[1]));
        if (p1[0] == p[0]) {
            return y * y;
        } else if (p1[1] == p[1]) {
            return x * x;
        } else {
            return x * x + y * y;
        }
    }
}