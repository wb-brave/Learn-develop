package exercise;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package exercise
 * @email wubin326@qq.com
 * @date 2018/09/21
 */
public class JudgeSquareTest {

    @Test
    public void validSquare() {
        int[] p1={1,0};
        int[] p2={-1,0};
        int[] p3={0,1};
        int[] p4={0,-1};
        JudgeSquare judgeSquare = new JudgeSquare();
        System.out.println(judgeSquare.validSquare(p1,p2,p3,p4));
    }
}