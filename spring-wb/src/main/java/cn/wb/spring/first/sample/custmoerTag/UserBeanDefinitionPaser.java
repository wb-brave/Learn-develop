package cn.wb.spring.first.sample.custmoerTag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionPaser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String pass = element.getAttribute("pass");
        if (StringUtils.hasText(name)){
            builder.addPropertyValue("name",name);
        }
        if (StringUtils.hasText(name)){
            builder.addPropertyValue("pass",pass);
        }
    }
}



