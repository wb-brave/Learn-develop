package thinkinjava.chapter15.generics.arrays;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics.arrays
 * @email wubin326@qq.com
 * @date 2018/11/20
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/20        wubin            0.0.1
 */
public class CovariantArrays {

    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        try {
            //虽然可以编译通过，但是会报存储错误 因为数组的实际类型是Apple的
            fruits[0] = new Fruit();
            // fruits[0] = new Apple(); 如果是这样存放则可以
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Fruit{}

class Apple extends Fruit{}

class Jonathan extends Apple{}

class Orange extends Fruit{}

