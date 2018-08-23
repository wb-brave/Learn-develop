package cn.wb.learning.rabbitmq.controller;

import cn.wb.learning.rabbitmq.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.rabbitmq.controller
 * @email wubin326@qq.com
 * @date 2018/08/22
 */
@RestController
public class Controller {

    @Autowired
    private Sender sender;

    @RequestMapping("/hello")
    public String send(){
        sender.send();
        return "Success";
    }
}
