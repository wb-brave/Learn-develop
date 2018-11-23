package thinkinjava.chapter15.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wubin
 * @Description 对面有潜在类型机制的补偿====反射
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/22
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/22        wubin            0.0.1
 */
public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new Mime());
        CommunicateReflectively.perform(new SmallDog());
        CommunicateReflectively.perform(new Robot());
    }
}

class Robot {
    public void speak() {
        System.out.println("click");
    }

    public void sit() {
        System.out.println("down");
    }

    public void oilChange() {

    }
}

class Mime {
    public void walkAgainstTheWind() {
    }

    public void sit() {
        System.out.println("Pretending to sit");
    }

    public void pushInvisibleWalls() {

    }

    @Override
    public String toString() {
        return "Mime{}";
    }
}

class SmallDog {
    public void speak() {
        System.out.println("WangWangWang!!!");
    }

    public void sit() {
        System.out.println("sitting");
    }

    public void repoduce() {

    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> aClass = speaker.getClass();
        try {
            Method speak = aClass.getMethod("speak");
            speak.invoke(speaker);
        } catch (NoSuchMethodException e) {
            System.out.println(speaker + " can not speak");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            Method sit = aClass.getMethod("sit");
            sit.invoke(speaker);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}