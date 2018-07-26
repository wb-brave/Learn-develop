package cn.wb.spring.first.sample.replaceMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ChangedTest {
    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        TestChangeMethod testChangeMethod = (TestChangeMethod)applicationContext.getBean("TestChangeMethod");
        testChangeMethod.changeMe();
    }

}