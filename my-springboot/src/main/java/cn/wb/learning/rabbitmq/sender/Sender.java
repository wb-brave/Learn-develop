package cn.wb.learning.rabbitmq.sender;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.rabbitmq.sender
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
@Component
public class Sender {
    public final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send() {
        String message = "测试消息";
        logger.info("发送消息 " + message);
        amqpTemplate.convertAndSend("message", message);
        return "success";
    }
}
