package cn.wb.spring.first.sample.aopTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AspectJTestTest {

    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aopTest/ApplicationContext.xml");
        TestBean testBean = (TestBean)applicationContext.getBean("test");
        testBean.test();
    }
}