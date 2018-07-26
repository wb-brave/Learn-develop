package cn.wb.spring.first.sample.custmoerTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport{
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionPaser());
    }
}
