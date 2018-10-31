package thinkinjava.chapter19.enums.enumofenum;

import org.junit.Test;

import static thinkinjava.chapter19.enums.enumofenum.Course.*;
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
public class CourseTest {

    @Test
    public void makeCourse() {
        for (int i = 0; i < 5; i++) {
            /**
             * 每次迭代整个course
             * 将course中的enmu类
             * 再随机选取一个
             */
            for (Course c: values()
                 ) {
                System.out.println(c.randomSelection());
            }
            System.out.println("=======================");
        }
    }
}