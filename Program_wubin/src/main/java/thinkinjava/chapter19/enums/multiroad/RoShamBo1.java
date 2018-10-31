package thinkinjava.chapter19.enums.multiroad;

import java.util.Random;

import static thinkinjava.chapter19.enums.multiroad.OutCome.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter19.enums.multiroad
 * @email wubin326@qq.com
 * @date 2018/10/31
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/10/31        wubin            0.0.1
 */
public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random random = new Random(47);

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }

    public static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Paper();
            case 1:
                return new Scissors();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        /**
         * string format
         * %d 表示数字
         * 'c' 直接嵌入到起前面的String字符串
         * %s表示 字符串 和 boolean
         */
        System.out.println(getShortname(a) + " vs. " + getShortname(b) + " : " + b.compete(a));
    }

    public static String getShortname(Item item){
        return item.getClass().getSimpleName();
    }
}

interface Item {
    /**
     * 具体的比较方法，调用eval，然后返回OUtcome的枚举实例
     *
     * @param item
     * @return
     */
    OutCome compete(Item item);

    OutCome eval(Paper paper);

    OutCome eval(Rock rock);

    OutCome eval(Scissors scissors);
}

class Paper implements Item {
    @Override
    public OutCome compete(Item item) {
        /**
         * 俩者顺序不能反，父类不能默认转换为子类
         * 以前一个对象作为标准
         * 实际调用的是第二个参数的方法
         */
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return EQUAL;
    }

    @Override
    public OutCome eval(Rock rock) {
        return WIN;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return LOSE;
    }

}

class Rock implements Item {

    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return LOSE;
    }

    @Override
    public OutCome eval(Rock rock) {
        return EQUAL;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return WIN;
    }
}

class Scissors implements Item {

    @Override
    public OutCome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public OutCome eval(Paper paper) {
        return WIN;
    }

    @Override
    public OutCome eval(Rock rock) {
        return LOSE;
    }

    @Override
    public OutCome eval(Scissors scissors) {
        return EQUAL;
    }
}