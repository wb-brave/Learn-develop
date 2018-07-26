package cn.wb.spring.first.sample.replaceMethod;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Changed implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        System.out.println("changed");
        return null;
    }
}
