package thinkinjava.chapter15.generics;

import static util.tuple.Tuple.*;

import util.tuple.TwoTuple;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object mixinObject = MixinProxy.newInstance(
                tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampedImpl(), TimeStamped.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class),
                tuple(new ColorImpl(), Color.class));
        Basic basic = (Basic) mixinObject;
        TimeStamped timeStamped = (TimeStamped) mixinObject;
        SerialNumbered serialNumbered = (SerialNumbered) mixinObject;
        Color color = (Color) mixinObject;
        basic.set("wubin");
        System.out.println(basic.get() + " " +
                timeStamped.getTimeStamp() + " " + serialNumbered.getSerialNumber() + " " + color.getColor());
    }
}

class MixinProxy implements InvocationHandler {
    private Object object;
    private Map<String, Object> delegatesByMethod;

    public MixinProxy(Object object) {
        this.object = object;
    }

    public MixinProxy(TwoTuple<String, Class<?>>... pairs) {
        this.delegatesByMethod = new HashMap<String, Object>();
        for (TwoTuple<String, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String name = method.getName();
                /**
                 * 保存不同接口的实现类，
                 */
                if (!delegatesByMethod.containsKey(name)) {
                    delegatesByMethod.put(name, pair.first);
                }
            }
        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        Object o = delegatesByMethod.get(name);
        return method.invoke(o, args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] classes = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            classes[i] = (Class) pairs[i].second;
        }
        ClassLoader classLoader = pairs[0].getClass().getClassLoader();
        /**
         * 通过这个方法去创建动态代理类
         * 入参有类加载器，要创建的【多个】接口，动态代理类的对象实例
         */
        return Proxy.newProxyInstance(classLoader, classes, new MixinProxy(pairs));
    }
}

interface Color {
    String getColor();
}

class ColorImpl implements Color {
    private final String color = "RED";

    @Override
    public String getColor() {
        return color;
    }
}
