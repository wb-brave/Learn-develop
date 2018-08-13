package cn.wb.spring.first.version4.extend;

import cn.wb.spring.first.version4.first.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wubin
 * @Description 实现BeanDefinitionRegistryPostProcessor，自定义实现bean的注入
 * @project Learn-develop
 * @package cn.wb.spring.first.version4.extend
 * @email wubin326@qq.com
 * @date 2018/08/10
 */
@Component
public class MyBeanregister implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int i = 0;
        while (i < 4) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class).rootBeanDefinition(User.class);
            beanDefinitionBuilder.addPropertyValue("name", "wb" + i);
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
            registry.registerBeanDefinition("user" + i, beanDefinition);
            i++;
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
