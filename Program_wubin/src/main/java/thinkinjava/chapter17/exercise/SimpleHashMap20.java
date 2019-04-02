package thinkinjava.chapter17.exercise;

import thinkinjava.chapter17.containers.MapEntry;
import util.sets.Countries;

import java.util.*;
import java.util.ListIterator;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/18        wubin            0.0.1
 */
public class SimpleHashMap20<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {

        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (Objects.isNull(buckets[index])) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = Boolean.FALSE;
        int countConfic = 0;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> next = it.next();
            try {
                if (Objects.equals(next.getKey(), key)) {
                    oldValue = next.getValue();
                    /**
                     * 将已经存在的key替换成新的
                     */
                    it.set(pair);
                    found = true;
                    throw new ConflictEntryException("key 冲突: " + key);
                } else {
                    countConfic++;
                }
            } catch (ConflictEntryException e) {
                System.out.println("经过探寻 " + countConfic + " 后 " + e.getMessage());
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {

        int index = Math.abs(key.hashCode()) % SIZE;
        if (Objects.isNull(buckets[index])) {
            return null;
        }
        for (MapEntry<K, V> entry : buckets[index]) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> entries = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (Objects.nonNull(bucket)) {
                for (MapEntry<K, V> entry : bucket) {
                    entries.add(entry);
                }
            }
        }
        return entries;
    }

    public static void main(String[] args) {
        SimpleHashMap20<String, String> map = new SimpleHashMap20<>();
        map.putAll(Countries.captital(10));
        map.put("BOTSWANA","asdasdasdas");
        System.out.println(map);
        System.out.println(map.get("ERITREA"));
        System.out.println(map.entrySet());
    }
}

class ConflictEntryException extends Exception {
    public ConflictEntryException() {
    }

    public ConflictEntryException(String message) {
        super(message);
    }
}
