package thinkinjava.chapter15.generics;

import util.generator.Generator;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter15.generics
 * @email wubin326@qq.com
 * @date 2018/11/19
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/19        wubin            0.0.1
 */
public class Ocean {
    private static void eat(BigFish bigFish,LittleFish littleFish){
        System.out.println(bigFish + " eat " + littleFish);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        LinkedList<BigFish> bigFish = new LinkedList<>();
        Generators.fill(bigFish,BigFish.generator(),10);

        LinkedList<LittleFish> littleFish = new LinkedList<>();
        Generators.fill(littleFish,LittleFish.generator(),10);
        for (BigFish fish : bigFish) {
            eat(fish,littleFish.get(random.nextInt(littleFish.size())));
        }

    }
}

class BigFish {
    private static Random random = new Random(47);
    private long counter = random.nextInt(8);
    private final long size = 10 + counter;

    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish{" +
                "size=" + size +
                '}';
    }

    public static Generator<BigFish> generator() {
        return () -> new BigFish();
    }
}

class LittleFish {
    private static Random random = new Random(47);
    private long counter = random.nextInt(6);
    private final long size = 5 + counter;

    private LittleFish() {
    }

    @Override
    public String toString() {
        return "LittleFish{" +
                "size=" + size +
                '}';
    }

    public static Generator<LittleFish> generator() {
        return () -> new LittleFish();
    }
}
