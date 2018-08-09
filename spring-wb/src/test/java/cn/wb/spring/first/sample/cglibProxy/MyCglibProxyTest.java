package cn.wb.spring.first.sample.cglibProxy;

import org.junit.Test;


public class MyCglibProxyTest {

    @Test
    public void test(){
        MyCglibProxy myCglibProxy = new MyCglibProxy();
        Cooking c = (Cooking) myCglibProxy.getInstance(new Cooking());
        c.cook();
    }

}