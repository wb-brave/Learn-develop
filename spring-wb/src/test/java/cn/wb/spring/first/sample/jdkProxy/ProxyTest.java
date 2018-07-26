package cn.wb.spring.first.sample.jdkProxy;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class ProxyTest {

    public static void main(String[] wn){
        UserService userService = new UserServiceImpl();
        MyInvacationHandler myInvacationHandler = new MyInvacationHandler(userService);
        UserService proxy = (UserService)myInvacationHandler.getProxy();
        proxy.add();
    }
}