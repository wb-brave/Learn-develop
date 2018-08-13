package cn.wb.spring.first.version4.extend;

import cn.wb.spring.first.version4.first.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
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
public class MyFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("----------ioc启动了： " + 18);
    }
}
