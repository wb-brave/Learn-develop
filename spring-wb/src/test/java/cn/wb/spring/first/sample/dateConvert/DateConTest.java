package cn.wb.spring.first.sample.dateConvert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class DateConTest {

    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dateConvert/ApplicationContext.xml");
        DateCon dateCon = (DateCon)applicationContext.getBean("test");
        System.out.println(dateCon.toString());
    }
}