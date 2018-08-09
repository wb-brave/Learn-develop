package cn.wb.spring.first.sample.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyCglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) {

        System.out.println("我是花钱请来做饭的代理");
        try {
            methodProxy.invokeSuper(o,objects);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("大功告成");
        return null;
    }

}
