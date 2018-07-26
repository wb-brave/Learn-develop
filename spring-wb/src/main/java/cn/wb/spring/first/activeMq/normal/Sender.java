package cn.wb.spring.first.activeMq.normal;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Sender {

    public static void main(String[] w) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        try {
            MessageProducer messageProducer = session.createProducer(destination);
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = session.createTextMessage("send message!");
                Thread.sleep(1000);
                messageProducer.send(textMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.commit();
            session.close();
            connection.close();
        }
    }
}
