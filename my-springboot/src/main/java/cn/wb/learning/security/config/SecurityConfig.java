package cn.wb.learning.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.learning.security
 * @email wubin326@qq.com
 * @date 2018/08/17
 */
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    // /css/**和/index的资源不需要验证，直接可以请求
    // /user/**的资源需要验证，权限是USER /admin/**的资源需要验证，权限是ADMIN
    // 登录地址是/login 登录失败地址是 /login_error
    // 异常重定向到 /401
    // 注销跳转到 /logout
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**","/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login_error")
                .and()
                .exceptionHandling().accessDeniedPage("/401");
        http.logout().logoutSuccessUrl("/logout");
    }

    //内存中创建用户，用户名为wubin，密码123456，权限是USER
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.inMemoryAuthentication()
                .withUser("wubin").password("123456")
        .roles("USER");
    }
}
