package thinkinjava.chapter22.beaninfo;

import thinkinjava.chapter14.factory.RegisteredFactories;

import java.beans.*;
import java.lang.reflect.Method;

/**
 * @author wubin
 * @Description 通过Introspector获取到javabean的所有信息
 * @project Learn-develop
 * @package thinkinjava.chapter22.beaninfo
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class Introspectors {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(RegisteredFactories.class, Object.class);

            for (PropertyDescriptor d : beanInfo.getPropertyDescriptors()) {
                Class<?> p = d.getPropertyType();
                if (p == null) continue;
                System.out.println("Property type:\n  " + p.getName() +
                        "Property name:\n  " + d.getName());
                Method readMethod = d.getReadMethod();
                if (readMethod != null)
                    System.out.println("Read method:\n  " + readMethod);
                Method writeMethod = d.getWriteMethod();
                if (writeMethod != null)
                    System.out.println("Write method:\n  " + writeMethod);
                System.out.println("====================");
            }
            System.out.println("Public methods:");
            for (MethodDescriptor m : beanInfo.getMethodDescriptors())
                System.out.println(m.getMethod().toString());
            System.out.println("======================");
            System.out.println("Event support:");
            for (EventSetDescriptor e : beanInfo.getEventSetDescriptors()) {
                System.out.println("Listener type:\n  " +
                        e.getListenerType().getName());
                for (Method lm : e.getListenerMethods())
                    System.out.println("Listener method:\n  " + lm.getName());
                for (MethodDescriptor lmd :
                        e.getListenerMethodDescriptors())
                    System.out.println("Method descriptor:\n  " + lmd.getMethod());
                Method addListener = e.getAddListenerMethod();
                System.out.println("Add Listener Method:\n  " + addListener);
                Method removeListener = e.getRemoveListenerMethod();
                System.out.println("Remove Listener Method:\n  " + removeListener);
                System.out.println("====================");
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
