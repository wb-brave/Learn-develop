package cn.wb.spring.first.springRmi.client;

import cn.wb.spring.first.springRmi.HelloRMIService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiTest {
    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springRmi/client/ApplicationContext.xml");
        HelloRMIService helloRMIService = applicationContext.getBean("clientRmi", HelloRMIService.class);
        System.out.println(helloRMIService.add(1,2));
    }
}
