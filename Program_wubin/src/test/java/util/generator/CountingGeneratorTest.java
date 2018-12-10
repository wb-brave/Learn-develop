package util.generator;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

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
public class CountingGeneratorTest {

    @Test
    public void test() {
        int size = 10;
        Class<?> surroundingClass = CountingGenerator.class;
        for (Class<?> aClass : surroundingClass.getClasses()) {
            System.out.println(aClass.getSimpleName() + " : ");
            try {
                /**
                 * 如果是非静态public类，会出现bug
                 */
                Generator<?> generator = (Generator<?>) aClass.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(generator.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}