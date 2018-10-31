package thinkinjava.chapter19.enums.aboutConst;

import java.util.EnumSet;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * 与匿名内部类相比较，定义常量相关方法的语法更加搞笑
 * @package thinkinjava.chapter19.enums.aboutConst
 * @email wubin326@qq.com
 * @date 2018/10/24
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/24        wubin            0.0.1
 */
public class CarWash {
    public enum Cycle{
        UNDERBODY{
            @Override
            void action() {
                System.out.println("spraying the underbody");
            }
        },
        WHEELWASH{
            @Override
            void action() {
                System.out.println("washing the wheel");
            }
        },
        BASIC{
            @Override
            void action() {
                System.out.println("the basic wash");
            }
        },
        RINSE{
            @Override
            void action() {
                System.out.println("Rinsing");
            }
        };
        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);

    public void add(Cycle c){
        this.cycles.add(c);
    }

    public void washCar(){
        for (Cycle cycle : cycles) {
            cycle.action();
        }
    }

    @Override
    public String toString() {
        return "CarWash{" +
                "cycles=" + cycles +
                '}';
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        System.out.println(carWash);
        carWash.washCar();

        carWash.add(Cycle.UNDERBODY);
        carWash.add(Cycle.UNDERBODY);
        carWash.add(Cycle.WHEELWASH);
        carWash.add(Cycle.RINSE);
        System.out.println(carWash);

        carWash.washCar();
    }
}
