package cn.wb.spring.first.cn.wb.spring.version4.first;

import cn.wb.spring.first.cn.wb.spring.version4.first.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.spring.first.cn.wb.spring.version4.first
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = User.class)})
public class AppConfig {
    @Bean(name = "user")
    public User createUser(){
        return new User();
    }
}
