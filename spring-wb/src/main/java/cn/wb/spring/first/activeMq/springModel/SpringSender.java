package cn.wb.spring.first.activeMq.springModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class SpringSender {
    public static void main(String[] wb){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("activeMq/ApplicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate");
        Destination destination = (Destination) applicationContext.getBean("destination");
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("spring message!");
            }
        });
    }
}
