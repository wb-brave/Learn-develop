package cn.wb.spring.first.sample.aopTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {
    @Pointcut("execution(* *.test(..))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("before test");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("after test");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p){

        System.out.println("defore 1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("After1");
        return o;
    }

}
