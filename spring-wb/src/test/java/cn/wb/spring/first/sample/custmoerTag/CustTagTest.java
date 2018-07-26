package cn.wb.spring.first.sample.custmoerTag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CustTagTest {

    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContextCust.xml");
        User user = (User)applicationContext.getBean("testBean");
        System.out.println(user.getName()+" "+user.getPass());
    }
}