package cn.wb.dubbo.controller;

import cn.wb.dubbo.service.interfaces.Hello;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.dubbo.controller
 * @email wubin326@qq.com
 * @date 2018/08/23
 */
@RestController
public class HelloController {

    @Reference(version = "0.0.1")
    Hello hello;

    @GetMapping("/hello")
    public String hello(String name){
        return hello.hello(name);
    }
}
