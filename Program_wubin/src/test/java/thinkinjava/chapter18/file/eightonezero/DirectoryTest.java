package thinkinjava.chapter18.file.eightonezero;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter18.file.eightonezero
 * @email wubin326@qq.com
 * @date 2018/10/09
 */
public class DirectoryTest {

    @Test
    public void testFile() {

        //all Directories
        PPrint.pprint(Directory.walk(".").dirs);

        //all files beginning with T
        for (File file:Directory.local(".","T.*")
             ) {
            System.out.println(file);
        }
        System.out.println("----------------------");

        //all files beginning with T
        for (File file:Directory.walk(".","T.*\\.java")
                ) {
            System.out.println(file);
        }
        System.out.println("=======================");

        //class files contains [z or Z]
        for (File file:Directory.walk(".",".*[Zz].*\\.class")
                ) {
            System.out.println(file);
        }
    }
}