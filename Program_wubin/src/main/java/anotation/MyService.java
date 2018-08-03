package anotation;

import java.lang.reflect.Method;

public class MyService {

    public static void main(String[] wn){
        test();
    }
    @MyAnotation(className = "anotation.MyServiceTest",methodName = "fuzhi")
    public static void test(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        try {
            Class clazz = Class.forName(stackTraceElements[1].getClassName());
            String methodName = stackTraceElements[1].getMethodName();
            Method method = clazz.getMethod(methodName,null);
            MyAnotation myAnotation = method.getAnnotation(MyAnotation.class);
            Class<?> aClass = Class.forName(myAnotation.className());
            Method method1 = Class.forName(myAnotation.className()).getDeclaredMethod(myAnotation.methodName(),null);
            method1.invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(456);
    }
}
