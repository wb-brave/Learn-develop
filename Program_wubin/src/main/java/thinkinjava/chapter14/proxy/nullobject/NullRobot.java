package thinkinjava.chapter14.proxy.nullobject;

import util.Null;

import java.lang.reflect.*;
import java.util.Collections;
import java.util.List;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.proxy.nullobject
 * @email wubin326@qq.com
 * @date 2018/11/05
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/05        wubin            0.0.1
 */
public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Robot.class},
                new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] bots = {
                new SnowRemovalRobot("SnowBee"),
                newNullRobot(SnowRemovalRobot.class)
        };
        for(Robot bot : bots)
            Robot.Test.test(bot);
    }
}

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    /**
     * 动态代理的类
     * 实际上是NRobot.他实现了robot的接口
     */
    private Robot proxied = new NRobot();

    public NullRobotProxyHandler(Class<? extends Robot> proxied) {
        nullName = proxied.getSimpleName() + " NullRobot";
    }

    private class NRobot implements Null, Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
