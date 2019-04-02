package thinkinjava.chapter17.containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/17
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/17        wubin            0.0.1
 */
public class SpringDetector {

    //使用GroundDog类，或它的子类
    public static <T extends GroundDog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> gDog = type.getConstructor(int.class);
        HashMap<GroundDog, Prediction> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(gDog.newInstance(i), new Prediction());
        }
        System.out.println("hashMap" + hashMap);
        GroundDog gh= gDog.newInstance(3);
        System.out.println("looking up prediction for " + gh);
        if (hashMap.containsKey(gh)){
            System.out.println(hashMap.get(gh));
        }else {
            /**
             * 找不到的原因：
             *  因为GroundDog没有重写Object的hashcode和equals方法
             *  hashcode是根据地址进行计算的，所以俩次的值是不一样的
             *  如果你只重写了hashcode方法也是不行，
             *  hashmap会根据equals方法去是否相等
             *  所以要正常工作，两个方法都需要重写
             */
            System.out.println("key not found " + gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectSpring(GroundDog.class);
        System.out.println("=======================");
        detectSpring(GroundDog2.class);
    }
}
