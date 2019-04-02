package util.sets;

import thinkinjava.chapter18.util.TextFile;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wubin
 * @Description 通过继承abstract集合类，来定制map以及set
 * @project Learn-develop
 * @package util.sets
 * @email wubin326@qq.com
 * @date 2018/12/10
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/10        wubin            0.0.1
 */
public class Countries {
    private static final String[] filedata = TextFile.read("/Users/wufan/wubin/github/Learn-develop/Program_wubin/src/main/resources/configfiles/countries.txt").split("#");
    public static final String[][] DATA = new String[filedata.length][2];
    private static boolean isInit = false;
    /**
     * 初始化数据
     */
    static {

        init();
    }

    private static void init() {
        if (!isInit){
            for (int i = 0; i < filedata.length; i++) {
                /**
                 * 将字符串两边的 " 删除，然后存入数组中
                 */
                DATA[i][0] = fetchValue(filedata[i])[0].replaceAll("\"", "");
                DATA[i][1] = fetchValue(filedata[i])[1].replaceAll("\"", "");
            }
            isInit = true;
        }
    }

    private static String[] fetchValue(String filedatum) {
        String[] strings = null;
        /**
         * 获取整个键值对的字符串
         * {"asdasda","asdasdas"}
         *          ||
         * "asdasda","asdasdas"
         */
        final Pattern compile = Pattern.compile("\"(\\w|\\W)+\"");
        final Matcher matcher = compile.matcher(filedatum);
        while (matcher.find()) {
            matcher.groupCount();
            strings = matcher.group().split(",");
        }
        return strings;
    }

    private static class FlyweightMap extends AbstractMap<String, String> {
        /**
         * 存储数据的私有静态内部类
         */
        private static class Entry implements Map.Entry<String, String> {
            int index;

            public Entry(int index) {
                this.index = index;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object o) {
                // if (this == o) return true;
                // if (o == null || getClass() != o.getClass()) return false;
                // Entry entry = (Entry) o;
                // return index == entry.index;
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {

                // return Objects.hash(index);
                return DATA[index][0].hashCode();
            }
        }

        /**
         * 封装上面Entry私有静态内部类的容器
         * 便于遍历等操作
         */
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;

            public EntrySet(int size) {
                if (size < 0) {
                    this.size = 0;
                } else if (size > DATA.length) {
                    //不能超过最大值
                    this.size = DATA.length;
                } else {
                    this.size = size;
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }


            @Override
            public int size() {
                return this.size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {

                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }
        }

        public Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }

    }
    /**
     * 根据size创建一个部分map
     * DATA的一部分的意思
     *
     * @param size
     * @return
     */
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    /**
     * 返回整个map
     */
    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> captital() {
        return map;
    }

    /**
     * 返回size部分的map
     *
     * @param size
     * @return
     */
    public static Map<String, String> captital(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(captital(10));
        System.out.println(names(10));
        System.out.println(new HashMap<>(captital(3)));
        System.out.println(new LinkedHashMap<>(captital(3)));
        System.out.println(new TreeMap<>(captital(3)));
        System.out.println(new Hashtable<>(captital(3)));
        System.out.println(new HashSet<>(names(6)));
        System.out.println(new LinkedHashSet<>(names(6)));
        System.out.println(new TreeSet<>(names(6)));
        System.out.println(new ArrayList<>(names(6)));
        System.out.println(new LinkedList<>(names(6)));
        System.out.println(captital().get("BRAZIL"));
    }
}
