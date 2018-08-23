package cn.wb.learning.rabbitmq.recevie;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.rabbitmq.recevie
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
@Component
@RabbitListener(queues = "message")
public class Recivier {

    public final Logger logger = Logger.getLogger(this.getClass());
    @RabbitHandler
    public void receive(String msg){
        logger.info("接收消息 " + msg);
        logger.info("接收时间 " + LocalDateTime.now());
    }
}
