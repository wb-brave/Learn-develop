package cn.wb.spring.first.version4.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package cn.wb.spring.first.version4.extend
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@Component
public class MyPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("----------before: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("----------after: " + beanName);
        return bean;
    }
}
