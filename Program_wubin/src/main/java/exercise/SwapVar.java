package exercise;

import suanfa.sort.SortAll;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2018/09/25
 */
public class SwapVar {

    public static void main(String[] args) {

        Integer first = new Integer(1);
        Integer second = new Integer(3);
        swap(first, second);
        System.out.println(first + " " + second);

        int a=2;
        int b=4;
        swap(a, b);
        System.out.println(a + " " + b);
        int i = 10;
        int j = 20;

        i = i ^ j;
        j = i ^ j;
        i = i ^ j;

        System.out.println("i=" + i + ";j=" + j);
    }

    private static void swap(Integer first, Integer second) {
        Integer temp = first.intValue();
//        first = new Integer(second.intValue());
//        second = new Integer(temp.intValue());
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(first,second);
            value.setInt(second,temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void swap(int first, int second) {

        int t = first;
        first = second;
        second = t;
    }

}
