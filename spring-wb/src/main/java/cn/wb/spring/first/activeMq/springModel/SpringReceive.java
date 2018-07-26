package cn.wb.spring.first.activeMq.springModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class SpringReceive {
    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("activeMq/ApplicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
        Destination destination = (Destination) applicationContext.getBean("destination");
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("receive message: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
