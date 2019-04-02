package thinkinjava.chapter17.containers;

import java.util.Map;
import java.util.Objects;

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
public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)){
            return false;
        }
        MapEntry me = (MapEntry) o;
        return (key==null?me.getKey()==null:key.equals(me.getKey()))
                && (value==null?me.getValue()==null:value.equals(me.getValue()));
    }

    @Override
    public int hashCode() {

        return (key == null ? 0 : key.hashCode() ^ (value == null ? 0 : value.hashCode()));
    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
