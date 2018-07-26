package cn.wb.spring.first.activeMq.normal;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Accpter {

    public static void main(String[] w) throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");
        try {
            MessageConsumer messageConsumer = session.createConsumer(destination);
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                session.commit();
                System.out.println("receive message: " + textMessage.getText());
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
