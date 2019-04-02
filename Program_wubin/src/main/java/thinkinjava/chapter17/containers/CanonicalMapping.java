package thinkinjava.chapter17.containers;

import java.util.Objects;
import java.util.WeakHashMap;

/**
 * @author wubin
 * @Description 典范映射
 * @project Learn-develop
 * @package thinkinjava.chapter17.containers
 * @email wubin326@qq.com
 * @date 2018/12/28
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2018/12/28        wubin            0.0.1
 */
public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 10;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if (i%3==0){
                keys[i] = key;
            }
            map.put(key,value);
        }
        System.gc();
    }
}

class Key extends Element {
    public Key(String ident) {
        super(ident);
    }
}

class Value extends Element {
    public Value(String ident) {
        super(ident);
    }
}

class Element {
    private String ident;

    public Element(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element that = (Element) o;
        return Objects.equals(ident, that.ident);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
    }
}
