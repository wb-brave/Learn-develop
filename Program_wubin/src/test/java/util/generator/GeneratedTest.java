package util.generator;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.generator
 * @email wubin326@qq.com
 * @date 2018/12/07
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/07        wubin            0.0.1
 */
public class GeneratedTest {

    @Test
    public void array() {
        Integer[] integers = {9, 8, 7, 6};
        System.out.println(Arrays.toString(integers));
        integers = Generated.array(integers, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(integers));
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 5);
        System.out.println(Arrays.toString(a));
    }
}