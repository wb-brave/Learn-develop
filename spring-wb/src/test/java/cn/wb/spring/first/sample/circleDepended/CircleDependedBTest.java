package cn.wb.spring.first.sample.circleDepended;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CircleDependedBTest {
    public static void main(String[] wb) throws Throwable{
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("circleDepenged/ApplicationContext.xml");
            TestA testA = (TestA)applicationContext.getBean("TestA");
//            testA.a();//循环依赖调用方法会出错
        } catch (Exception e) {
            Throwable throwable = e.getCause().getCause().getCause();
            throw throwable;
        }

    }

}