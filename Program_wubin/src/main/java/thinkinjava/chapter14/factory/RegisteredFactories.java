package thinkinjava.chapter14.factory;

import util.TypeCounter;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter5.factory
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Part.class);
        for (int i = 1; i <= 10; i++) {
            System.out.print(Part.createRandom()+" ");
            if (i%5==0){
                System.out.println();
            }
            typeCounter.count(Part.createRandom());
        }
        System.out.print(typeCounter);
    }
}

class Part {
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    private static Random rand = new Random(47);

    /**
     * 使用一个工厂基类，来限定map中的类型信息
     * 排除上一个存放在数组中的缺陷
     * @return
     */
    public static Part createRandom() {
        int i = rand.nextInt(partFactories.size());
        /**
         * 实际上调用的是每个子类的create（）的方法
         * eq：FuelFilter.Factory#create()
         */
        return partFactories.get(i).create();
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    static {
        //region 使用的是显示构造方法类初始化类
        // partFactories.add(new FuelFilter.Factory());
        // partFactories.add(new AirFilter.Factory());
        // partFactories.add(new CabinAirFilter.Factory());
        // partFactories.add(new OilFilter.Factory());
        // partFactories.add(new FanBelt.Factory());
        // partFactories.add(new PowerSteeringBelt.Factory());
        // partFactories.add(new GeneratorBelt.Factory());
        //endregion
        try {
            partFactories.add(FuelFilter.Factory.class.newInstance());
            partFactories.add(AirFilter.Factory.class.newInstance());
            partFactories.add(CabinAirFilter.Factory.class.newInstance());
            partFactories.add(OilFilter.Factory.class.newInstance());
            partFactories.add(FanBelt.Factory.class.newInstance());
            partFactories.add(PowerSteeringBelt.Factory.class.newInstance());
            partFactories.add(GeneratorBelt.Factory.class.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 作为分类的标识
 */
class Filter extends Part {
}

class FuelFilter extends Filter {
    // Create a Class Factory for each specific type:

    /**
     * 创建一个静态内部类来继承工厂基类，
     * 可以通过使用接口来保存
     * 不同实例的引用
     * 这就是多态
     */
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<FuelFilter> {
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<AirFilter> {
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<OilFilter> {
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

/**
 * 作为分类的标识
 */
class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<FanBelt> {
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory
            implements thinkinjava.chapter14.factory.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}
