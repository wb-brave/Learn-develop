package cn.wb.dubbo.service.impl;

import cn.wb.dubbo.service.interfaces.Hello;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.dubbo.service.impl
 * @email wubin326@qq.com
 * @date 2018/08/23
 */
@Service(version = "0.0.1")
public class HelloImpl implements Hello {
    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}
