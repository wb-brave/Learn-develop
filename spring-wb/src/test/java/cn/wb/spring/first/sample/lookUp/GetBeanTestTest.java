package cn.wb.spring.first.sample.lookUp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanTestTest {

    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        GetBeanTest getBeanTest = (GetBeanTest) applicationContext.getBean("GetBeanTest");
        getBeanTest.showMe();

    }
}