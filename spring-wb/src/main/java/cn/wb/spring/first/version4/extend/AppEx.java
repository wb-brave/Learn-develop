package cn.wb.spring.first.version4.extend;

import cn.wb.spring.first.version4.first.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.spring.first.cn.wb.spring.version4.first
 * @email wubin326@qq.com
 * @date 2018/08/09
 */
public class AppEx {
    public static void main(String[] wb){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext("cn.wb.spring.first.version4.extend");
        System.out.println(annotationConfigApplicationContext.getBeanDefinitionCount());

        //获取所有的bean，然后循环打印每个bean
        annotationConfigApplicationContext.getBeansOfType(User.class).values().forEach(System.out::println);
//        System.out.println(annotationConfigApplicationContext.getBean("user1"));
    }
}
