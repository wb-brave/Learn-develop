package thinkinjava.chapter18.stream.afterexercise;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.stream.afterexercise
 * @email wubin326@qq.com
 * @date 2018/10/10
 */
public class Exercise7Test {

    @Test
    public void read() throws Exception {
        String f = "/Users/wufan/Desktop/test.txt";
        Exercise7.read(f,null);
    }

    @Test
    public void readFromArgs() throws Exception {
        String f = "/Users/wufan/Desktop/test.txt";
        Exercise7.read(f,null);
    }
}