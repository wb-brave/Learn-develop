package thinkinjava.chapter17.containers;

import javafx.util.Pair;
import util.generator.*;
import util.sets.MapData;

import java.util.Iterator;

/**
 * @author wubin
 * @Description 测试工具类mapData
 * @project Learn-develop
 * @package util.sets
 * @email wubin326@qq.com
 * @date 2018/12/10
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/10        wubin            0.0.1
 */
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),11));

        /**
         * 根据俩个genenrator类和一个size创建一个LinkedHashMap
         */
        System.out.println(MapData.map(new CountingGenerator.Character(),
                new RandomGenerator.String(5),8));
        /**
         * 根据一个genenrator类、一个固定值和size创建一个LinkedHashMap
         */
        System.out.println(MapData.map(new CountingGenerator.Character(),
                "value",6));
        /**
         * 根据迭代器和一个genenrator类创建一个LinkedHashMap
         */
        System.out.println(MapData.map(new Letters(),new RandomGenerator.String(3)));
        /**
         * 根据迭代器和一个固定的值创建一个LinkedHashMap
         */
        System.out.println(MapData.map(new Letters(),"wb"));
    }
}

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private int size = 9;
    private int number = 1;
    private char letter = 'A';


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + (letter++));
    }
}