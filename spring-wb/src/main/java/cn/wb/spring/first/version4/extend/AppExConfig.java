package cn.wb.spring.first.version4.extend;

import cn.wb.spring.first.version4.first.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.spring.first.cn.wb.spring.version4.first
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
@Configuration
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = User.class)})
@ComponentScan
public class AppExConfig {
    @Bean(name = "user1")
    public User getUser(){
        return new User();
    }
}