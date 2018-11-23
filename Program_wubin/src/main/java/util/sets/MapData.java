package util.sets;

import javafx.util.Pair;
import util.generator.Generator;

import java.util.LinkedHashMap;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util
 * @email wubin326@qq.com
 * @date 2018/11/02
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/11/02        wubin            0.0.1
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    /**
     * pair一个专门来存储key-value键值对的类
     * 根据pair来生成迭代器
     *
     * @param gen
     * @param quantity
     */
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> next = gen.next();
            put(next.getKey(), next.getValue());
        }
    }

    /**
     * 分别根据key和value来生成的 generator
     *
     * @param genK
     * @param genV
     * @param quantity
     */
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    /**
     * 为不同的key分配给定的值
     *
     * @param genK
     * @param value
     * @param quantity
     */
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }

    /**
     * 只根据一个迭代器和generator填充map
     *
     * @param genK
     * @param genV
     */
    public MapData(Iterable<K> genK, Generator<V> genV) {

        for (K k : genK
                ) {
            put(k, genV.next());
        }
    }

    public MapData(Iterable<K> genK, V value) {

        for (K k : genK
                ) {
            put(k, value);
        }
    }

    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> pairGenerator, int quantity) {
        return new MapData<>(pairGenerator, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<>(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData<>(genK, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<>(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<>(genK, value);
    }
}
