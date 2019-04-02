package thinkinjava.chapter17.containers;

import util.sets.CountingMapData;

import java.util.*;

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
public class SlowMap16<K,V> extends AbstractMap<K,V> {

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
        // HashSet<Map.Entry<K, V>> entries = new HashSet<>();
        // Iterator<K> kIterator = keys.iterator();
        // Iterator<V> vIterator = values.iterator();
        // while (kIterator.hasNext()){
        //     entries.add(new MapEntry<>(kIterator.next(),vIterator.next()));
        // }
        return entries;
    }
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    private Set<Map.Entry<K,V>> entries = new EntrySet();

    private class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        public EntrySet() {
        }

        @Override
        public Iterator<Map.Entry<K,V>> iterator() {
            return new Itr();
        }

        @Override
        public int size() {
            return keys.size();
        }

        class Itr implements Iterator<Map.Entry<K,V>>{

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index<size();
            }

            @Override
            public MapEntry<K,V> next() {
                if (index<size()){
                    int temp = index++;
                    return new MapEntry<>(keys.get(temp),values.get(temp));
                }
                throw new NoSuchElementException();
            }
        }
    }

    public static void main(String[] args) {
        SlowMap16<Integer, String> slowMap16 = new SlowMap16<>();
        slowMap16.put(1,"w");
        slowMap16.put(2,"u");
        slowMap16.put(3,"b");
        slowMap16.put(4,"i");
        slowMap16.put(5,"n");
        slowMap16.put(5,"g");
        Set<Entry<Integer, String>> entries = slowMap16.entrySet();
        Iterator<Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

