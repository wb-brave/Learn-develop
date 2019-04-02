package util.sets;

import java.util.*;

/**
 * @author wubin
 * @Description
 * @project Learn-develop
 * @package util.sets
 * @email wubin326@qq.com
 * @date 2018/12/11
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/11        wubin            0.0.1
 */
public class CountingMapData extends AbstractMap<Integer, String> {

    private int size;
    private static final String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        this.size = size < 0 ? 0 : size;
    }

    private static class Entry implements Map.Entry<Integer, String> {

        private int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(java.lang.String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return index == entry.index;
        }

        @Override
        public int hashCode() {

            return Objects.hash(index);
        }
    }

    // public static Set<Map.Entry<Integer,String>> entries = new EntrySet(chars.length);
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        LinkedHashSet<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    //    使用自定义的EntrySet
    //     return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(30));
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

        private int size;

        public EntrySet(int size) {
            this.size = size > 0 ? size > chars.length ? chars.length : size : 0;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Intr();
        }

        @Override
        public int size() {
            return size;
        }

        private class Intr implements Iterator<Map.Entry<Integer,String>>{
            Entry entry = new Entry(-1);

            @Override
            public boolean hasNext() {
                return entry.index<size-1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }
        }
    }
}
