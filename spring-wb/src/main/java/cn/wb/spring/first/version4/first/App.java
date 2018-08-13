package cn.wb.spring.first.version4.first;

import cn.wb.spring.first.springmvc.sample.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.spring.first.cn.wb.spring.version4.first
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
public class App {
    public static void main(String[] wb){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("cn.wb.spring.first.cn.wb.spring.version4.first");

        System.out.println(annotationConfigApplicationContext.getBean(User.class));
    }
}
